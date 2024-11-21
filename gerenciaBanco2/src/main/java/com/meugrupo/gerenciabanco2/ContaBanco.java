package com.meugrupo.gerenciabanco2;

/**
 * Classe responsável pelas operações bancárias básicas.
 * 
 * @author Eng. Ricardo Jose Rodrigues
 */
public class ContaBanco {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    // Construtor da classe ContaBanco
    public ContaBanco(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0; // Saldo inicial é zero
    }

    // Método para consultar o saldo
    public double consultarSaldo() {
        return saldo;
    }

    // Método para depositar valores na conta
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$%.2f realizado com sucesso.%n", valor);
        } else {
            System.out.println("O valor do depósito deve ser maior que zero.");
        }
    }

    // Método para sacar valores da conta
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.printf("Saque de R$%.2f realizado com sucesso.%n", valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}

