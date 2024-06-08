package br.com.fiap.main;

import br.com.fiap.beans.Login;

import java.util.Scanner;

public class TesteBouncerApi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Login login = new Login(email, senha);

        boolean isEmailValid = login.verifyEmail();
        if (isEmailValid) {
            System.out.println("O email é válido.");
        } else {
            System.out.println("O email é inválido.");
        }
        
        scanner.close();
    }
}
