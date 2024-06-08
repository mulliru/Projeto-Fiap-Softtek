package br.com.fiap.exceptions;

public class excecoes extends Exception {

    private static final long serialVersionUID = 1L;

    public excecoes() {
        super("Mensagem de falha");
    }

    public excecoes(String mensagem) {
        super(mensagem);
    }

    public excecoes(Exception e) {
        super(e);
        if (e instanceof NumberFormatException) {
            System.out.println("Digite um email válido");
        } else {
            System.out.println("Falha desconhecida");
            e.printStackTrace();
        }
    }
}
