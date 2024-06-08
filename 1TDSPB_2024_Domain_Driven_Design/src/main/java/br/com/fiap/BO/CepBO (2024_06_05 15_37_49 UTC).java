package br.com.fiap.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.DAO.CepDAO;
import br.com.fiap.beans.Cep;


public class CepBO {
	
	// Inserir
	
		public void inserirBo (Cep cep) throws ClassNotFoundException, SQLException {
			CepDAO cepDAO = new CepDAO();
			
		// Regras de negócio
			
			cepDAO.inserir(cep);
		}
		
		// Alterar
		
		public void atualizarBo (Cep cep) throws ClassNotFoundException, SQLException {
			CepDAO cepDAO = new CepDAO();
			
		// Regras de negócio
			
			cepDAO.atualizar(cep);
		}
		
		// Deletar
		
		public void deletarBo (int Id) throws ClassNotFoundException, SQLException {
			CepDAO cepDAO = new CepDAO();
			
		// Regras de negócio
			cepDAO.deletar(Id);
		}
		
		// Selecionar
		public ArrayList<Cep> selecionarBo() throws ClassNotFoundException, SQLException {
			CepDAO cepDAO = new CepDAO();
			
		// Regra de negócio
			return (ArrayList<Cep>) cepDAO.selecionar();
		}

}
