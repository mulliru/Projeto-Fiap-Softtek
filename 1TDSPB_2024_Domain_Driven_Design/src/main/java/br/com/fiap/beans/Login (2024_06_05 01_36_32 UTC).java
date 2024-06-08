package br.com.fiap.beans;

import br.com.fiap.services.BouncerApi;
import br.com.fiap.model.EmailVerificationResult;

import java.io.IOException;

public class Login {
	
	private String email;
	private String senha;
	
	public Login() {
		super();
	}

	public Login(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean verifyEmail() {
		BouncerApi bouncerApi = new BouncerApi();
		try {
			EmailVerificationResult verificationResult = bouncerApi.verifyEmail(this.email);
			System.out.println("A verificação do Email: " + verificationResult.toString());
			return "deliverable".equals(verificationResult.getStatus());
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
