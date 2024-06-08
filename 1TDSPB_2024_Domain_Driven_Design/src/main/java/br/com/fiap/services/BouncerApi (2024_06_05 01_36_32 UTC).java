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

import br.com.fiap.model.EmailVerificationResult;

public class BouncerApi {

    private static final String API_URL = "https://api.usebouncer.com/v1.1/email/verify?email=";
    private static final String API_KEY = "fBgRyPFbQguDchGwgwv1Od1Fawh5hPdP9cjLNUyJ"; // Substitua com sua API Key

    public EmailVerificationResult verifyEmail(String email) throws ClientProtocolException, IOException {
        
        EmailVerificationResult emailVerificationResult = null;
        
        // Crie a requisição HTTP GET
        HttpGet request = new HttpGet(API_URL + email);
        
        // Adicione a chave da API no cabeçalho de autenticação
        request.addHeader("Authorization", "Basic " + java.util.Base64.getEncoder().encodeToString((":" + API_KEY).getBytes()));
        
        CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
        
        // Execute a requisição e obtenha a resposta
        CloseableHttpResponse response = httpClient.execute(request);
        
        HttpEntity entity = response.getEntity();
        
        if (entity != null) {
            String result = EntityUtils.toString(entity);
            Gson gson = new Gson();
            emailVerificationResult = gson.fromJson(result, EmailVerificationResult.class);
        }
        return emailVerificationResult;
    }
}
