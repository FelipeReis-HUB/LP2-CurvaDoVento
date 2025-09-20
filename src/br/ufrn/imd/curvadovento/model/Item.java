package br.ufrn.imd.curvadovento.model;

public class Item {
    private String nome;
    private double preco;

    // Construtor para inicializar os atributos
    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Métodos 'get' para acessar os valores
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}