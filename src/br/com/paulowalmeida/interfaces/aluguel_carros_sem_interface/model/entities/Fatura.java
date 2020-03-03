package br.com.paulowalmeida.interfaces.aluguel_carros_sem_interface.model.entities;

public class Fatura {
    private double pagamentoBase;
    private double taxa;

    public Fatura(double pagamentoBase, double taxa) {
        this.pagamentoBase = pagamentoBase;
        this.taxa = taxa;
    }

    public Fatura() {
    }

    public double pagamentoTotal(){
        return this.pagamentoBase + this.taxa;
    }

    public double getPagamentoBase() {
        return pagamentoBase;
    }

    public Fatura setPagamentoBase(double pagamentoBase) {
        this.pagamentoBase = pagamentoBase;
        return this;
    }

    public double getTaxa() {
        return taxa;
    }

    public Fatura setTaxa(double taxa) {
        this.taxa = taxa;
        return this;
    }
}
