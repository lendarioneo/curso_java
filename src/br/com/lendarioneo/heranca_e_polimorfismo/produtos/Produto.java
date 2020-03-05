package br.com.lendarioneo.heranca_e_polimorfismo.produtos;

public abstract class Produto {
    protected String nome;
    protected double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String gerarEtiquetaPreco(){
        return nome + "\nR$ " + preco;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }
}
