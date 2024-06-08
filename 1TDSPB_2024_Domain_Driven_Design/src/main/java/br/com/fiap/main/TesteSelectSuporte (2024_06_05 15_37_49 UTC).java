package br.com.fiap.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.DAO.SuporteDAO;
import br.com.fiap.beans.Suporte;

public class TesteSelectSuporte {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Instanciar objetos 
		SuporteDAO dao = new SuporteDAO();
		
		List<Suporte> listaSuporte = (ArrayList<Suporte>) dao.selecionar();
		
		if(listaSuporte != null) {
			// foreach 
			for( Suporte suporte : listaSuporte) {
				System.out.println
								(suporte.getIdAtendimento() + " " + 
								suporte.getHrsInicio() + " " +
								suporte.getHrsTermino() + " " +
								suporte.getNotaFeedback() + " ");
			}
		}
	}
}
