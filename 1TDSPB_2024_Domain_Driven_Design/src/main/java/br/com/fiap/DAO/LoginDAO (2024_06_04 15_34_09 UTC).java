package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Login;

import br.com.fiap.conexoes.ConexaoFactory;

public class LoginDAO {
	
	public Connection minhaConexao;
	
	public LoginDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
		
		public String inserir(Login login) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					("Insert into T_Login values (?, ?)");
			
					stmt.setString(1, login.getEmail());
					stmt.setString(2, login.getSenha());

					stmt.execute();
					stmt.close();
		
		return "Login Válido com sucesso";
  
	}
		
		// Delete
		public String deletar(String email) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					("Delete from T_Login where EMAIL = ?");
				stmt.setString(1, email);
				stmt.execute();
				stmt.close();		
			return "Deletado com Sucesso!";
		}
	// UpDate 
		public String atualizar(Login login) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					(" Update T_Login set EMAIL = ?, SENHA = ?, "
							+ "where EMAILF = ?");
					stmt.setString(1, login.getEmail());
					stmt.setString(2, login.getSenha());
					stmt.executeUpdate();
					stmt.close();	
			return "Atualizado com Sucesso!";
		}
		// Select 
		public List<Login> selecionar() throws SQLException{
			List<Login> listaLogin = new ArrayList<Login>();
			PreparedStatement stmt = minhaConexao.prepareStatement
					("SELECT * FROM T_Login");
			
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					Login login = new Login();
					login.setEmail(rs.getString(1));;
					login.setSenha(rs.getString(2));

					listaLogin.add(login);
				}		
			return listaLogin;		
		}
}
