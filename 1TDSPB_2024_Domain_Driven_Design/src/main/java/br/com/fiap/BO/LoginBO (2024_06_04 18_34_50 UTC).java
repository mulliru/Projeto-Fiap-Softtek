package br.com.fiap.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.DAO.LoginDAO;
import br.com.fiap.beans.Login;


public class LoginBO {
	
	// Inserir
	
		public void inserirBo (Login login) throws ClassNotFoundException, SQLException {
			LoginDAO loginDAO = new LoginDAO();
			
		// Regras de negócio
			
			loginDAO.inserir(login);
		}
		
		// Alterar
		
		public void atualizarBo (Login login) throws ClassNotFoundException, SQLException {
			LoginDAO loginDAO = new LoginDAO();
			
		// Regras de negócio
			
			loginDAO.atualizar(login);
		}
		
		// Deletar
		
		public void deletarBo (String login) throws ClassNotFoundException, SQLException {
			LoginDAO loginDAO = new LoginDAO();
			
		// Regras de negócio
			loginDAO.deletar(login);
		}
		
		// Selecionar
		public ArrayList<Login> selecionarBo() throws ClassNotFoundException, SQLException {
			LoginDAO loginDAO = new LoginDAO();
			
		// Regra de negócio
			return (ArrayList<Login>) loginDAO.selecionar();
		}

}
