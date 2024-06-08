package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.DAO.ClienteDAO;
import br.com.fiap.beans.Cliente;


public class TesteDeleteCliente {

	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	
	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos 
		Cliente objCliente = new Cliente();
		
		ClienteDAO dao = new ClienteDAO();
		
		objCliente.setCpf(texto("Digite o CPF da pessoa a ser deletada"));
		
		System.out.println(dao.deletar(objCliente.getCpf()));

	}

}
