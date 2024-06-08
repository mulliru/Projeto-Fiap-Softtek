package br.com.fiap.main;

import br.com.fiap.exceptions.excecoes;

import java.util.Scanner;

public class TesteBouncerApi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite seu email: ");
            String email = scanner.nextLine();

            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            boolean isEmailValid = verifyEmail(email);
            boolean isPasswordValid = verifyPassword(senha);

            if (isEmailValid && isPasswordValid) {
                System.out.println("O email e a senha são válidos.");
            }
        } catch (excecoes e) {
            // Handle known exceptions
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            // Handle unknown exceptions
            new excecoes(e);
        } finally {
            scanner.close();
        }
    }

    public static boolean verifyEmail(String email) throws excecoes {
        if (email == null || email.isEmpty()) {
            throw new excecoes("Email não pode ser vazio.");
        }

        // Simulating a simple email validation
        if (!email.contains("@") || !email.contains(".")) {
            throw new excecoes(new NumberFormatException());
        }

        return true; // Assume the email is valid if it passes the checks
    }

    public static boolean verifyPassword(String senha) throws excecoes {
        if (senha == null || senha.isEmpty()) {
            throw new excecoes("Senha não pode ser vazia.");
        }

        return true; // Assume the password is valid if it passes the checks
    }
}
