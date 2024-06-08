package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.DAO.SuporteDAO;
import br.com.fiap.beans.Suporte;


public class TesteDeleteSuporte {

	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	
	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos 
		Suporte objSuporte = new Suporte();
		
		SuporteDAO dao = new SuporteDAO();
		
		objSuporte.setIdAtendimento(inteiro("Digite o CPF da pessoa a ser deletada"));
		
		System.out.println(dao.deletar(objSuporte.getIdAtendimento()));

	}

}
