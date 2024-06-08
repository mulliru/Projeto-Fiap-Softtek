package br.com.fiap.beans;

public class Cep {
	private int idCep;
	private String pais;
	private String estado;
	private String logradouro;
	private int numero;
	
	public Cep() {
		super();
	}

	public Cep(int idCep, String pais, String estado, String logradouro, int numero) {
		super();
		this.idCep = idCep;
		this.pais = pais;
		this.estado = estado;
		this.logradouro = logradouro;
		this.numero = numero;
	}



	public int getIdCep() {
		return idCep;
	}



	public void setIdCep(int idCep) {
		this.idCep = idCep;
	}



	public String getPais() {
		return pais;
	}



	public void setPais(String pais) {
		this.pais = pais;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getLogradouro() {
		return logradouro;
	}



	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	

}
