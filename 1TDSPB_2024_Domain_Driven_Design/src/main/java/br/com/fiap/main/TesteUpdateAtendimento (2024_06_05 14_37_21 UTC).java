package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.DAO.AtendimentoDAO;
import br.com.fiap.beans.Atendimento;

public class TesteUpdateAtendimento {

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
		Atendimento objAtendimento = new Atendimento();
		
		AtendimentoDAO dao = new AtendimentoDAO();
		
		objAtendimento.setIdFuncionario(inteiro("Insira o ID a ser alterado: "));
		objAtendimento.setNomeAtendente(texto("Nome do Atendente: "));
		objAtendimento.setCargo(texto("Cargo: "));

		
		System.out.println(dao.atualizar(objAtendimento));

	}

}
