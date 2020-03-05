package br.com.lendarioneo.heranca_e_polimorfismo.imposto;

public abstract class Pessoa {

    protected String nome;
    protected double rendaAnual;

    public Pessoa(String nome, double rendaAnual) {
        this.nome = nome;
        this.rendaAnual = rendaAnual;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public double getRendaAnual() {
        return rendaAnual;
    }

    public abstract double calcularImposto();
}
