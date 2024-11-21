package com.meugrupo.gerenciabanco;

import java.util.Scanner;
import java.io.PrintStream;

/**
 * Sistema de Gerenciamento Bancário.
 * 
 * @author Eng. Ricardo Jose Rodrigues
 */
class ContaBancaria {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public ContaBancaria(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$%.2f realizado com sucesso.%n", valor);
        } else {
            System.out.println("O valor do depósito deve ser maior que zero.");
        }
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.printf("Saque de R$%.2f realizado com sucesso.%n", valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}

public class GerenciaBanco {
    public static void main(String[] args) throws Exception {
        // Define o charset UTF-8 no console
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        Scanner scanner = new Scanner(System.in);

        // Exibição do cabeçalho
        System.out.println("##################################################");
        System.out.println("**************************************************");
        System.out.println("####      Sistema de Controle Bancário        ####");
        System.out.println("**************************************************");
        System.out.println("##################################################");
        System.out.print("Informe seu nome: ");
        
        String nome = scanner.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf);

        while (true) {
            System.out.println("\n1. Consultar saldo");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Realizar saque");
            System.out.println("4. Sair");
            System.out.print("Digite o número da opção desejada: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    double saldo = conta.consultarSaldo();
                    System.out.printf("Saldo disponível: R$%.2f%n", saldo);
                    break;
                case 2:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 4:
                    System.out.println("Encerrando o programa... Tenha um bom dia!");
                    scanner.close();
                    return; // Finaliza o programa
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
