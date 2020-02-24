package br.com.paulowalmeida.heranca_e_polimorfismo.produtos;

public class ProdutoImportado extends Produto {
    private double taxaAlfandega;

    public ProdutoImportado(String nome, double preco, double taxaAlfandega) {
        super(nome, preco);
        this.taxaAlfandega = taxaAlfandega;
    }

    @Override
    public String gerarEtiquetaPreco() {
        return nome + "\nR$ " + calcularPrecoTotal() + "\nTaxa Alfandêga: " + taxaAlfandega;
    }

    public double calcularPrecoTotal(){
        return preco + taxaAlfandega;
    }
}
