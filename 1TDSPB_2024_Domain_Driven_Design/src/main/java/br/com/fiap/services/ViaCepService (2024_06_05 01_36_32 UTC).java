package br.com.fiap.services;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import br.com.fiap.model.CepApi;

public class ViaCepService {
	
	public CepApi getEnderecoAPI(String cep) throws ClientProtocolException, IOException {
		
		CepApi enderecoAPI = null;
		
		// Com o HttpGet fazemos a requisição 
		HttpGet request = new HttpGet("https://viacep.com.br/ws/"+cep+"/json/");
		
		CloseableHttpClient httpClient =
				HttpClientBuilder.create().disableRedirectHandling().build();
		
		// para obter a resposta 
		CloseableHttpResponse response = httpClient.execute(request);
		
		
		HttpEntity entity = response.getEntity();
		
		if(entity != null) {
			
			String result = EntityUtils.toString(entity);
			
			Gson gson = new Gson();
			
			enderecoAPI = gson.fromJson(result, CepApi.class);			
		}		
		
		return enderecoAPI;
	}	


}
