package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.DAO.DownloadProdutoDAO;
import br.com.fiap.beans.DownloadProduto;


public class DownloadProdutoCadastro {
	
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
		
		DownloadProduto objDownloadProduto = new DownloadProduto();
		
		DownloadProdutoDAO dao = new DownloadProdutoDAO();
		

		objDownloadProduto.setIdProduto(texto("Id do produto: "));
		objDownloadProduto.setHrsAquisicao(texto("Digite o horário da aquisicao"));
		objDownloadProduto.setDiaAquisicao(texto("Digite o dia da aqusição: "));

		
		System.out.println(dao.inserir(objDownloadProduto));

	}

}
