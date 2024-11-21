package com.meugrupo.gerenciabanco2;
import java.util.Scanner;

public class AplicarBanco {

    // Método para mostrar o menu de investimentos
    public static void menuInvestimentos(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Menu de Investimentos ---");
            System.out.println("1. Investir em CDB (10% ao ano)");
            System.out.println("2. Investir em LCI (8% ao ano)");
            System.out.println("3. Voltar ao menu principal");
            System.out.print("Digite o número da opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    investirCDB(scanner);
                    break;
                case 2:
                    investirLCI(scanner);
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Método para calcular o rendimento do CDB
    private static void investirCDB(Scanner scanner) {
        System.out.print("\nDigite o valor a ser investido em CDB: ");
        double valorInvestido = scanner.nextDouble();
        System.out.print("Digite a quantidade de meses para o investimento: ");
        int meses = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        double rendimentoAnual = valorInvestido * 0.10;  // 10% ao ano
        double rendimentoMensal = rendimentoAnual / 12; // Rendimento mensal

        double totalRendimentos = rendimentoMensal * meses;
        double valorFinal = valorInvestido + totalRendimentos;

        System.out.println("\nRelatório do Investimento em CDB:");
        System.out.printf("Valor Investido: R$%.2f%n", valorInvestido);
        System.out.printf("Rendimento Mensal: R$%.2f%n", rendimentoMensal);
        System.out.printf("Total Investido: R$%.2f%n", valorFinal);
        System.out.printf("Rendimento Total: R$%.2f%n", totalRendimentos);
    }

    // Método para calcular o rendimento do LCI
    private static void investirLCI(Scanner scanner) {
        System.out.print("\nDigite o valor a ser investido em LCI: ");
        double valorInvestido = scanner.nextDouble();
        System.out.print("Digite a quantidade de meses para o investimento: ");
        int meses = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        double rendimentoAnual = valorInvestido * 0.08;  // 8% ao ano
        double rendimentoMensal = rendimentoAnual / 12; // Rendimento mensal

        double totalRendimentos = rendimentoMensal * meses;
        double valorFinal = valorInvestido + totalRendimentos;

        System.out.println("\nRelatório do Investimento em LCI:");
        System.out.printf("Valor Investido: R$%.2f%n", valorInvestido);
        System.out.printf("Rendimento Mensal: R$%.2f%n", rendimentoMensal);
        System.out.printf("Total Investido: R$%.2f%n", valorFinal);
        System.out.printf("Rendimento Total: R$%.2f%n", totalRendimentos);
    }
}

