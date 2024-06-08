package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.DAO.LoginDAO;
import br.com.fiap.beans.Login;


public class LoginCadastro {
	
	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	
	static double real(String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Login objLogin = new Login();
		
		LoginDAO dao = new LoginDAO();
		

		objLogin.setEmail(texto("Email:"));
		objLogin.setSenha(texto("Senha: "));

		
		System.out.println(dao.inserir(objLogin));

	}

}
