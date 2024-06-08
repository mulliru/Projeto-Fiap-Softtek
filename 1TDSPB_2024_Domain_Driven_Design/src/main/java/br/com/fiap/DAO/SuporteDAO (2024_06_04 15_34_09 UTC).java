package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Suporte;

import br.com.fiap.conexoes.ConexaoFactory;

public class SuporteDAO {
	
	public Connection minhaConexao;
	
	public SuporteDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
		
		public String inserir(Suporte suporte) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					("Insert into T_Suporte values (?, ?, ?, ?)");
			
					stmt.setInt(1, suporte.getIdAtendimento());
					stmt.setString(2, suporte.getHrsInicio());
					stmt.setString(3, suporte.getHrsTermino());
					stmt.setInt(4, suporte.getNotaFeedback());
					stmt.execute();
					stmt.close();
		
		return "Suporte cadastrado com sucesso";
  
	}
		
		// Delete
		public String deletar(int IdAtendimento) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					("Delete from T_Suporte where IDATENDIMENTO = ?");
				stmt.setInt(1, IdAtendimento);
				stmt.execute();
				stmt.close();		
			return "Deletado com Sucesso!";
		}
	// UpDate 
		public String atualizar(Suporte suporte) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					(" Update T_Suporte set IDATENDIMENTO = ?, HRSINICIO = ?, "
							+ "  HRSTERMINO = ?, NOTAFEEDBACK = ? = ? where CPF = ?");
					stmt.setInt(1, suporte.getIdAtendimento());
					stmt.setString(2, suporte.getHrsInicio());
					stmt.setString(3, suporte.getHrsTermino());
					stmt.setInt(4, suporte.getNotaFeedback());
					stmt.executeUpdate();
					stmt.close();	
			return "Atualizado com Sucesso!";
		}
		// Select 
		public List<Suporte> selecionar() throws SQLException{
			List<Suporte> listaSuporte = new ArrayList<Suporte>();
			PreparedStatement stmt = minhaConexao.prepareStatement
					("SELECT * FROM T_Suporte");
			
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					Suporte suporte = new Suporte();
					suporte.setIdAtendimento(rs.getInt(1));;
					suporte.setHrsInicio(rs.getString(2));
					suporte.setHrsTermino(rs.getString(3));
					suporte.setNotaFeedback(rs.getInt(4));

					listaSuporte.add(suporte);
				}		
			return listaSuporte;		
		}
}
