package br.com.fiap.beans;

public class Atendimento {

	private String idFuncionario;
	private String nomeAtendente;
	private String cargo;
	
	public Atendimento() {
		super();
	}

	public Atendimento(String idFuncionario, String nomeAtendente, String cargo) {
		super();
		this.idFuncionario = idFuncionario;
		this.nomeAtendente = nomeAtendente;
		this.cargo = cargo;
	}

	public String getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
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
