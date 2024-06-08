package br.com.fiap.beans;

public class Suporte {

	private int idAtendimento;
	private String hrsInicio;
	private String hrsTermino;
	private int notaFeedback;

	public Suporte() {
		super();
	}

	public Suporte(int idAtendimento, String hrsInicio, String hrsTermino, int notaFeedback) {
		super();
		this.idAtendimento = idAtendimento;
		this.hrsInicio = hrsInicio;
		this.hrsTermino = hrsTermino;
		this.notaFeedback = notaFeedback;
	}

	public int getIdAtendimento() {
		return idAtendimento;
	}

	public void setIdAtendimento(int idAtendimento) {
		this.idAtendimento = idAtendimento;
	}

	public String getHrsInicio() {
		return hrsInicio;
	}

	public void setHrsInicio(String hrsInicio) {
		this.hrsInicio = hrsInicio;
	}

	public String getHrsTermino() {
		return hrsTermino;
	}

	public void setHrsTermino(String hrsTermino) {
		this.hrsTermino = hrsTermino;
	}

	public int getNotaFeedback() {
		return notaFeedback;
	}

	public void setNotaFeedback(int notaFeedback) {
		this.notaFeedback = notaFeedback;
	}
}
