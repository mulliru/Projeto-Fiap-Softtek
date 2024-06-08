package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.DAO.SuporteDAO;
import br.com.fiap.beans.Suporte;

public class TesteUpdateSuporte {

	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	
	static double real (String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos
		Suporte objSuporte = new Suporte();
		
		SuporteDAO dao = new SuporteDAO();
		
		objSuporte.setIdAtendimento(inteiro("Insira o ID a ser alterado"));
		objSuporte.setHrsInicio(texto("Hora de inicio: "));
		objSuporte.setHrsTermino(texto("Hora de término: "));
		objSuporte.setNotaFeedback(inteiro("Nota do feedback (1-5): "));

		
		System.out.println(dao.atualizar(objSuporte));

	}

}
