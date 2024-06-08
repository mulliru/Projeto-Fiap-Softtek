package br.com.fiap.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.DAO.ClienteDAO;
import br.com.fiap.beans.Cliente;

public class TesteSelectCliente {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Instanciar objetos 
		ClienteDAO dao = new ClienteDAO();
		
		List<Cliente> listaCliente = (ArrayList<Cliente>) dao.selecionar();
		
		if(listaCliente != null) {
			// foreach 
			for( Cliente cliente : listaCliente) {
				System.out.println
								(cliente.getName() + " " + 
								cliente.getCpf() + " " +
								cliente.getRg() + " " + 
								cliente.getEmail() + " " +
								cliente.getCelular() + " ");
			}
		}
	}
}
