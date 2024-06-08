package br.com.fiap.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.DAO.SuporteDAO;
import br.com.fiap.beans.Suporte;


public class SuporteBO {
	
	// Inserir
	
		public void inserirBo (Suporte suporte) throws ClassNotFoundException, SQLException {
			SuporteDAO suporteDAO = new SuporteDAO();
			
		// Regras de negócio
			
			suporteDAO.inserir(suporte);
		}
		
		// Alterar
		
		public void atualizarBo (Suporte suporte) throws ClassNotFoundException, SQLException {
			SuporteDAO suporteDAO = new SuporteDAO();
			
		// Regras de negócio
			
			suporteDAO.atualizar(suporte);
		}
		
		// Deletar
		
		public void deletarBo (int idAtendimento) throws ClassNotFoundException, SQLException {
			SuporteDAO suporteDAO = new SuporteDAO();
			
		// Regras de negócio
			suporteDAO.deletar(idAtendimento);
		}
		
		// Selecionar
		public ArrayList<Suporte> selecionarBo() throws ClassNotFoundException, SQLException {
			SuporteDAO suporteDAO = new SuporteDAO();
			
		// Regra de negócio
			return (ArrayList<Suporte>) suporteDAO.selecionar();
		}

}
