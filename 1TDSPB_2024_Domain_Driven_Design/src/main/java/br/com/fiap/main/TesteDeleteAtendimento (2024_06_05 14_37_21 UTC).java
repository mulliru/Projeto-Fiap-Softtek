package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.DAO.AtendimentoDAO;
import br.com.fiap.beans.Atendimento;


public class TesteDeleteAtendimento {

	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	
	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos 
		Atendimento objAtendimento = new Atendimento();
		
		AtendimentoDAO dao = new AtendimentoDAO();
		
		objAtendimento.setIdFuncionario(inteiro("Digite o ID do funcionário a ser deletada"));
		
		System.out.println(dao.deletar(objAtendimento.getIdFuncionario()));

	}

}
