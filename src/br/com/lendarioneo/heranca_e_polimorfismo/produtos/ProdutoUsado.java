package br.com.lendarioneo.heranca_e_polimorfismo.produtos;

import java.util.Date;

public class ProdutoUsado extends Produto {

    private Date dataFabricacao;

    public ProdutoUsado(String nome, double preco, Date dataFabricacao) {
        super(nome, preco);
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String gerarEtiquetaPreco() {
        return super.gerarEtiquetaPreco() + "\nData de Fabricação: " + dataFabricacao;
    }
}
