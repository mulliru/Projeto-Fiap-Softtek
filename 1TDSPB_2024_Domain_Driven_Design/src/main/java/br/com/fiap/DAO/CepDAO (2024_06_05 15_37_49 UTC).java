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
					("Insert into T_CEP values (?, ?, ?, ?, ?, ?, ?)");
			
					stmt.setInt(1, cep.getId());
					stmt.setString(2, cep.getPais());
					stmt.setString(3, cep.getEstado());
					stmt.setString(4, cep.getCidade());
					stmt.setString(5, cep.getLogradouro());
					stmt.setString(6, cep.getCep());
					stmt.setInt(7, cep.getNumero());
					stmt.execute();
					stmt.close();
		
		return "Atendimento cadastrado com sucesso";
  
	}
		
		// Delete
		public String deletar(int Id) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					("Delete from T_CEP where ID = ?");
				stmt.setInt(1, Id);
				stmt.execute();
				stmt.close();		
			return "Deletado com Sucesso!";
		}
	// UpDate 
		public String atualizar(Cep cep) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					(" Update T_CEP set ID = ?, PAIS = ?, ESTADO = ?, "
							+ "  CIDADE = ?, LOGRADOURO = ?, CEP =?, NUMERO = ? where CEP = ?");
							stmt.setInt(1, cep.getId());
							stmt.setString(2, cep.getPais());
							stmt.setString(3, cep.getEstado());
							stmt.setString(4, cep.getCidade());
							stmt.setString(5, cep.getLogradouro());
							stmt.setString(6, cep.getCep());
							stmt.setInt(7, cep.getNumero());
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
					cep.setId(rs.getInt(1));;
					cep.setPais(rs.getString(2));;
					cep.setEstado(rs.getString(3));
					cep.setCidade(rs.getString(4));
					cep.setLogradouro(rs.getString(5));
					cep.setCep(rs.getString(6));
					cep.setNumero(rs.getInt(7));
					listaCep.add(cep);
				}		
			return listaCep;		
		}
}
