package com.mycompany.estoqueapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Produto {
    private final String nome;
    private final int quantidade;
    private final double preco;

    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Quantidade: " + quantidade + ", Preço: R$" + String.format("%.2f", preco);
    }
}
public class EstoqueApp {
    private static final List<Produto> produtos = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== Gerenciamento de Estoque ===");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opcao: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Opcao inválida! Tente novamente.");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarProduto();
                case 2 -> listarProdutos();
                case 3 -> System.out.println("Saindo...");
                default -> System.out.println("Opcao inválida! Tente novamente.");
            }
        } while (opcao != 3);
    }

    private static void adicionarProduto() {
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();

        System.out.print("Quantidade: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Quantidade inválida! Digite um número inteiro.");
            scanner.next();
        }
        int quantidade = scanner.nextInt();

        System.out.print("Preco: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Preco inválido! Digite um número decimal.");
            scanner.next();
        }
        double preco = scanner.nextDouble();
        scanner.nextLine();

        produtos.add(new Produto(nome, quantidade, preco));
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void listarProdutos() {
        System.out.println("\n=== Lista de Produtos ===");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
