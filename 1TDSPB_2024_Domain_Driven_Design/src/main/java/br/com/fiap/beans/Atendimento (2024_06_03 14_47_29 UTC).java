package br.com.fiap.beans;

public class Atendimento {

	private int idFuncionario;
	private String nomeAtendente;
	private String cargo;
	
	public Atendimento() {
		super();
	}

	public Atendimento(int idFuncionario, String nomeAtendente, String cargo) {
		super();
		this.idFuncionario = idFuncionario;
		this.nomeAtendente = nomeAtendente;
		this.cargo = cargo;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int string) {
		this.idFuncionario = string;
	}

	public String getNomeAtendente() {
		return nomeAtendente;
	}

	public void setNomeAtendente(String nomeAtendente) {
		this.nomeAtendente = nomeAtendente;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

}
