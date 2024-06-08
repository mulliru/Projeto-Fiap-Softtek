package br.com.fiap.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cep {

    private int id;
    private String pais;
    private String estado;
    private String cidade;
    private String logradouro;
    private String cep; // Mantido como 'cep'
    private int numero;
    private String bairro;
    private String localidade;
    private String uf;
    private String complemento;

    // Construtor padrão
    public Cep() {
        super();
    }

    // Construtor com todos os parâmetros
    public Cep(int id, String pais, String estado, String cidade, String logradouro, String cep, int numero, String bairro, String localidade, String uf, String complemento) {
        super();
        this.id = id;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.complemento = complemento;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
