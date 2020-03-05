package br.com.paulowalmeida.interfaces.contratos.model.entities;

import br.com.paulowalmeida.interfaces.contratos.model.services.FormataData;

import java.util.Date;

public class Parcela {
    private Date dataPagamento;
    private Double valorParcela;

    public Parcela(Date dataPagamento, Double valorParcela) {
        this.dataPagamento = dataPagamento;
        this.valorParcela = valorParcela;
    }

    public Parcela() {
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public void getInfoParcelas() {
        System.out.println("Data Pagamento Parcela: " + FormataData.formatar(getDataPagamento()));
        System.out.println("Valor Parcela: " + getValorParcela());
    }
}