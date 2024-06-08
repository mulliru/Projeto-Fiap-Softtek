package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.fiap.beans.Cep;
import br.com.fiap.conexoes.ConexaoFactory;

public class CepDAO {
	
	public Connection minhaConexao;
	
	public CepDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
		
		public String inserir(Cep cep) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					("Insert into T_CEP values (?, ?, ?, ?, ?, ?)");
			
					stmt.setString(1, cep.getPais());
					stmt.setString(2, cep.getEstado());
					stmt.setString(3, cep.getCidade());
					stmt.setString(4, cep.getLogradouro());
					stmt.setString(5, cep.getCep());
					stmt.setInt(6, cep.getNumero());
					stmt.execute();
					stmt.close();
		
		return "Atendimento cadastrado com sucesso";
  
	}
		
		// Delete
		public String deletar(String Cep) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					("Delete from T_CEP where CEP = ?");
				stmt.setString(1, Cep);
				stmt.execute();
				stmt.close();		
			return "Deletado com Sucesso!";
		}
	// UpDate 
		public String atualizar(Cep cep) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					(" Update T_CEP set PAIS = ?, ESTADO = ?, "
							+ "  CIDADE = ?, LOGRADOURO = ?, CEP =?, NUMERO = ? where CEP = ?");
					stmt.setString(1, cep.getPais());
					stmt.setString(2, cep.getEstado());
					stmt.setString(3, cep.getCidade());
					stmt.setString(3, cep.getLogradouro());
					stmt.setString(3, cep.getCep());
					stmt.setInt(3, cep.getNumero());
					stmt.executeUpdate();
					stmt.close();	
			return "Atualizado com Sucesso!";
		}
		// Select 
		public List<Cep> selecionar() throws SQLException{
			List<Cep> listaCep = new ArrayList<Cep>();
			PreparedStatement stmt = minhaConexao.prepareStatement
					("SELECT * FROM T_CEP");
			
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					Cep cep = new Cep();
					cep.setPais(rs.getString(1));;
					cep.setEstado(rs.getString(2));
					cep.setCidade(rs.getString(3));
					cep.setLogradouro(rs.getString(4));
					cep.setCep(rs.getString(5));
					cep.setNumero(rs.getInt(6));
					listaCep.add(cep);
				}		
			return listaCep;		
		}
}
