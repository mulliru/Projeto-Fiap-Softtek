package br.com.fiap.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.DAO.ClienteDAO;
import br.com.fiap.beans.Cliente;


public class ClienteBO {
	
	// Inserir
	
		public void inserirBo (Cliente cliente) throws ClassNotFoundException, SQLException {
			ClienteDAO clienteDAO = new ClienteDAO();
			
		// Regras de negócio
			
			clienteDAO.inserir(cliente);
		}
		
		// Alterar
		
		public void atualizarBo (Cliente cliente) throws ClassNotFoundException, SQLException {
			ClienteDAO clienteDAO = new ClienteDAO();
			
		// Regras de negócio
			
			clienteDAO.atualizar(cliente);
		}
		
		// Deletar
		
		public void deletarBo (String cpf) throws ClassNotFoundException, SQLException {
			ClienteDAO clienteDAO = new ClienteDAO();
			
		// Regras de negócio
			clienteDAO.deletar(cpf);
		}
		
		// Selecionar
		public ArrayList<Cliente> selecionarBo() throws ClassNotFoundException, SQLException {
			ClienteDAO clienteDAO = new ClienteDAO();
			
		// Regra de negócio
			return (ArrayList<Cliente>) clienteDAO.selecionar();
		}

}
