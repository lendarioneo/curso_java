package br.com.paulowalmeida.arquivos.contab_produtos.model.entities;

public class Produto {
    private String nome;
    private double valor;
    private int quantidade;

    public Produto(String nome, double valor, int quantidade) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public double calcularTotal(){
        return valor * quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString(){
       return  "Produto: " + getNome() +
               "\nValor: " + getValor() +
               "\nQuantidade: " + getQuantidade() +
               "\nTotal: " + calcularTotal() +
               "\n--------------------------------\n";
    }
}
