package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.DAO.AtendimentoDAO;
import br.com.fiap.beans.Atendimento;


public class AtendimentoCadastro {
	
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
		
		Atendimento objAtendimento = new Atendimento();
		
		AtendimentoDAO dao = new AtendimentoDAO();
		

		objAtendimento.setIdFuncionario(inteiro("Id do funcionário: "));
		objAtendimento.setNomeAtendente(texto("Digite o nome do Atendente:"));
		objAtendimento.setCargo(texto("Digite o cargo: "));

		
		
		System.out.println(dao.inserir(objAtendimento));

	}

}
