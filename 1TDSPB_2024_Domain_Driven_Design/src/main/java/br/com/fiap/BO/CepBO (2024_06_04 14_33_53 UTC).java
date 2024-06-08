package br.com.fiap.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.DAO.CEpDAO;
import br.com.fiap.beans.Atendimento;


public class CepBO {
	
	// Inserir
	
		public void inserirBo (Cep cep) throws ClassNotFoundException, SQLException {
			AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
			
		// Regras de negócio
			
			atendimentoDAO.inserir(atendimento);
		}
		
		// Alterar
		
		public void atualizarBo (Atendimento atendimento) throws ClassNotFoundException, SQLException {
			AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
			
		// Regras de negócio
			
			atendimentoDAO.atualizar(atendimento);
		}
		
		// Deletar
		
		public void deletarBo (int idAtendimento) throws ClassNotFoundException, SQLException {
			AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
			
		// Regras de negócio
			atendimentoDAO.deletar(idAtendimento);
		}
		
		// Selecionar
		public ArrayList<Atendimento> selecionarBo() throws ClassNotFoundException, SQLException {
			AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
			
		// Regra de negócio
			return (ArrayList<Atendimento>) atendimentoDAO.selecionar();
		}

}
