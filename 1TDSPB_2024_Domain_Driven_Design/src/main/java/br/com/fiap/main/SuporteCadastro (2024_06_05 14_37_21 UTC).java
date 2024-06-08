package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.DAO.SuporteDAO;
import br.com.fiap.beans.Suporte;


public class SuporteCadastro {
	
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
		
		Suporte objSuporte = new Suporte();
		
		SuporteDAO dao = new SuporteDAO();
		

		objSuporte.setIdAtendimento(inteiro("Id do atendimento: "));
		objSuporte.setHrsInicio(texto("Digite o horário inicial do atendimento: "));
		objSuporte.setHrsTermino(texto("Digite o horário final do atendimento: "));
		objSuporte.setNotaFeedback(inteiro("Nos dê um feedback(1-5): "));
		
		
		System.out.println(dao.inserir(objSuporte));

	}

}
