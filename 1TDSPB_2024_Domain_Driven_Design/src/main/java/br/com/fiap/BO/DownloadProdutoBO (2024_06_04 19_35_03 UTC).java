package br.com.fiap.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.DAO.DownloadProdutoDAO;
import br.com.fiap.beans.DownloadProduto;


public class DownloadProdutoBO {
	
	// Inserir
	
		public void inserirBo (DownloadProduto downloadProduto) throws ClassNotFoundException, SQLException {
			DownloadProdutoDAO downloadProdutoDAO = new DownloadProdutoDAO();
			
		// Regras de negócio
			
			downloadProdutoDAO.inserir(downloadProduto);
		}
		
		// Alterar
		
		public void atualizarBo (DownloadProduto downloadProduto) throws ClassNotFoundException, SQLException {
			DownloadProdutoDAO downloadProdutoDAO = new DownloadProdutoDAO();
			
		// Regras de negócio
			
			downloadProdutoDAO.atualizar(downloadProduto);
		}
		
		// Deletar
		
		public void deletarBo (String idProduto) throws ClassNotFoundException, SQLException {
			DownloadProdutoDAO downloadProdutoDAO = new DownloadProdutoDAO();
			
		// Regras de negócio
			downloadProdutoDAO.deletar(idProduto);
		}
		
		// Selecionar
		public ArrayList<DownloadProduto> selecionarBo() throws ClassNotFoundException, SQLException {
			DownloadProdutoDAO downloadProdutoDAO = new DownloadProdutoDAO();
			
		// Regra de negócio
			return (ArrayList<DownloadProduto>) downloadProdutoDAO.selecionar();
		}

}
