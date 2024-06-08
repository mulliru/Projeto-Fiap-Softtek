package br.com.fiap.beans;

public class Cliente {

	private String name;
	private String cpf;
	private String rg ;
	private String email ;
	private Cep cep;
	private int celular;
	
	public Cliente() {
		super();
	}

	public Cliente(String name, String cpf, String rg, String email, Cep cep, int celular) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.cep = cep;
		this.celular = celular;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cep getCep() {
		return cep;
	}

	public void setCep(Cep cep) {
		this.cep = cep;
	}

	public int getCelular() {
		return celular;
	}
	
	public void setCelular(int celular) {
		this.celular = celular;
	}
	
	
	
	
}
