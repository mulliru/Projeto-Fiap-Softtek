package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.DAO.ClienteDAO;
import br.com.fiap.beans.Cliente;


public class ClienteCadastro {
	
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
		
		Cliente objCliente = new Cliente();
		
		ClienteDAO dao = new ClienteDAO();
		

		objCliente.setName(texto("Nome do Cliente: "));
		objCliente.setCpf(texto("Digite o CPF: "));
		objCliente.setRg(texto("Digite o RG: "));
		objCliente.setEmail(texto("Digite o email:"));
		objCliente.setCelular(inteiro("Digite o celular:"));
		
		
		System.out.println(dao.inserir(objCliente));

	}

}
