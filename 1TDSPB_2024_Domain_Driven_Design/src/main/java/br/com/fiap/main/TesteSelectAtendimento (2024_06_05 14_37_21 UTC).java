package br.com.fiap.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.DAO.AtendimentoDAO;
import br.com.fiap.beans.Atendimento;

public class TesteSelectAtendimento {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Instanciar objetos 
		AtendimentoDAO dao = new AtendimentoDAO();
		
		List<Atendimento> listaAtendimento = (ArrayList<Atendimento>) dao.selecionar();
		
		if(listaAtendimento != null) {
			// foreach 
			for( Atendimento atendimento : listaAtendimento) {
				System.out.println
						(atendimento.getIdFuncionario() + " " + 
						atendimento.getNomeAtendente() + " " +
						atendimento.getCargo() + " ");
			}
		}
	}
}
