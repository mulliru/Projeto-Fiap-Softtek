package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Atendimento;

import br.com.fiap.conexoes.ConexaoFactory;

public class AtendimentoDAO {
	
	public Connection minhaConexao;
	
	public AtendimentoDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
		
		public String inserir(Atendimento atendimento) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					("Insert into T_SALES_ATENDIMENTO values (?, ?, ?, ?)");
			
					stmt.setInt(1, atendimento.getIdFuncionario());
					stmt.setString(2, atendimento.getNomeAtendente());
					stmt.setString(3, atendimento.getCargo());
					stmt.execute();
					stmt.close();
		
		return "Atendimento cadastrado com sucesso";
  
	}
		
		// Delete
		public String deletar(int idFuncionario) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					("Delete from T_SALES_ATENDIMENTO where IDATENDIMENTO = ?");
				stmt.setInt(1, idFuncionario);
				stmt.execute();
				stmt.close();		
			return "Deletado com Sucesso!";
		}
	// UpDate 
		public String atualizar(Atendimento atendimento) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					(" Update T_SALES_ATENDIMENTO set HRSINICIO = ?, HRSTERMINO = ?, "
							+ "  FEEDBACK = ? where IDATENDIMENTO = ?");
					stmt.setInt(1, atendimento.getIdFuncionario());
					stmt.setString(2, atendimento.getNomeAtendente());
					stmt.setString(3, atendimento.getCargo());
					stmt.executeUpdate();
					stmt.close();	
			return "Atualizado com Sucesso!";
		}
		// Select 
		public List<Atendimento> selecionar() throws SQLException{
			List<Atendimento> listaAtendimento = new ArrayList<Atendimento>();
			PreparedStatement stmt = minhaConexao.prepareStatement
					("SELECT * FROM T_SALES_ATENDIMENTO");
			
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					Atendimento atendimento = new Atendimento();
					atendimento.setIdFuncionario(rs.getInt(1));;
					atendimento.setNomeAtendente(rs.getString(2));
					atendimento.setCargo(rs.getString(3));
					listaAtendimento.add(atendimento);
				}		
			return listaAtendimento;		
		}
}
