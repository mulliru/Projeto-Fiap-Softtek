package br.com.fiap.beans;

public class DownloadProduto {

	private String idProduto;
	private int hrsAquisicao;
	private String diaAquisicao;
	
	public DownloadProduto() {
		super();
	}

	public DownloadProduto(String idProduto, int hrsAquisicao, String diaAquisicao) {
		super();
		this.idProduto = idProduto;
		this.hrsAquisicao = hrsAquisicao;
		this.diaAquisicao = diaAquisicao;
	}



	public String getIdProduto() {
		return idProduto;
	}



	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}



	public int getHrsAquisicao() {
		return hrsAquisicao;
	}



	public void setHrsAquisicao(int hrsAquisicao) {
		this.hrsAquisicao = hrsAquisicao;
	}



	public String getDiaAquisicao() {
		return diaAquisicao;
	}



	public void setDiaAquisicao(String diaAquisicao) {
		this.diaAquisicao = diaAquisicao;
	}
	
	
	
}
