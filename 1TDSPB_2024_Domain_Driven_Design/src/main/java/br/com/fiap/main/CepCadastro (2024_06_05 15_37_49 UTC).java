package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.DAO.CepDAO;
import br.com.fiap.beans.Cep;


public class CepCadastro {
	
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
		
		Cep objCep = new Cep();
		
		CepDAO dao = new CepDAO();
		
		objCep.setId(inteiro("Id: "));
		objCep.setPais(texto("Pais: "));
		objCep.setEstado(texto("Estado: "));
		objCep.setCidade(texto("Cidade: "));
		objCep.setLogradouro(texto("Logradouro:"));
		objCep.setCep(texto("CEP:"));
		objCep.setNumero(inteiro("Número: "));
		
		
		System.out.println(dao.inserir(objCep));

	}

}
