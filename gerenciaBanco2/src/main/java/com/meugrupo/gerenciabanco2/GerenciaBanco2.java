package com.meugrupo.gerenciabanco2;

import java.io.PrintStream;
import java.util.Scanner;

public class GerenciaBanco2 {
    public static void main(String[] args) throws Exception {
        // Define o charset UTF-8 no console
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        // Código existente
        Scanner scanner = new Scanner(System.in);

        System.out.println("**************************************************");
        System.out.println("####       Sistema de Controle Bancário      #####");
        System.out.println("**************************************************");

        System.out.print("Informe seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Informe seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Informe seu CPF: ");
        String cpf = scanner.nextLine();

        // Cria a conta bancária com as informações do cliente
        ContaBanco conta = new ContaBanco(nome, sobrenome, cpf);

        while (true) {
            // Menu principal
            System.out.println("\nEscolha uma opção:");
            System.out.println("a) Transações comuns");
            System.out.println("b) Investimentos");
            System.out.println("x) Sair");
            System.out.print("Digite sua opção: ");
            String opcao = scanner.nextLine().trim().toLowerCase(); // Lê a opção e converte para minúscula

            switch (opcao) {
                case "a":
                    menuTransacoesComuns(scanner, conta);
                    break;
                case "b":
                    AplicarBanco.menuInvestimentos(scanner); // Presumo que o método 'menuInvestimentos' esteja implementado em outra classe
                    break;
                case "x":
                    System.out.println("Encerrando o programa... Obrigado por utilizar o sistema!");
                    scanner.close();
                    return; // Finaliza o programa
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Método para transações comuns
    private static void menuTransacoesComuns(Scanner scanner, ContaBanco conta) {
        while (true) {
            System.out.println("\n--- Transações Comuns ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Realizar saque");
            System.out.println("4. Voltar ao menu principal");
            System.out.print("Digite o número da opção desejada: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha após a leitura do número

            switch (opcao) {
                case 1:
                    System.out.printf("Saldo disponível: R$%.2f%n", conta.consultarSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine(); // Consumir quebra de linha
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine(); // Consumir quebra de linha
                    conta.sacar(valorSaque);
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");
                    return; // Volta ao menu principal
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
