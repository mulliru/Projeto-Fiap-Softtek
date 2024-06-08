package br.com.fiap.main;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.http.client.ClientProtocolException;

import br.com.fiap.model.CepApi;
import br.com.fiap.services.ViaCepService;

public class ViaCepExecucao {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		ViaCepService viaCepService  = new ViaCepService();
		
		String cep = JOptionPane.showInputDialog("Informe o CEP para pesquisa");
		
		CepApi enderecoAPI = viaCepService.getEnderecoAPI(cep);
		
		// Saida toString 
		System.out.println(enderecoAPI);	
		
	}

}
