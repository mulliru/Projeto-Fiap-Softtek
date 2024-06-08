package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.DAO.ClienteDAO;
import br.com.fiap.beans.Cliente;

public class TesteUpdateCliente {

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
		Cliente objCliente = new Cliente();
		
		ClienteDAO dao = new ClienteDAO();
		
		objCliente.setName(texto("Insira o nome a ser alterado"));
		objCliente.setCpf(texto("CPF: "));
		objCliente.setRg(texto("RG: "));
		objCliente.setEmail(texto("Email: "));
		objCliente.setCelular(inteiro("Celular: "));

		
		System.out.println(dao.atualizar(objCliente));

	}

}
