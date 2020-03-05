package br.com.paulowalmeida.interfaces.contratos.model.entities;

import br.com.paulowalmeida.interfaces.contratos.model.services.FormataData;

import java.util.Date;
import java.util.List;

public class Contrato {
    private int numero;
    private Date data;
    private double valorTotal;
    private List<Parcela> parcelas;

    public Contrato(int numero, Date data, double valorTotal, List<Parcela> parcelas) {
        this.numero = numero;
        this.data = data;
        this.valorTotal = valorTotal;
        this.parcelas = parcelas;
    }

    public int getNumero() {
        return numero;
    }

    public Contrato setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public Date getData() {
        return data;
    }

    public Contrato setData(Date data) {
        this.data = data;
        return this;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Contrato setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public Contrato setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
        return this;
    }

    public void exibeInformacoes() {
        System.out.println("-----Resumo do contrato------");
        System.out.println("Número:" + this.getNumero());
        System.out.println("Data :" + FormataData.formatar(this.getData()));
        System.out.println("Valor:" + this.getValorTotal());
        System.out.println("Informações das Parcelas");
        for (int i = 0; i < parcelas.size(); i++) {
            System.out.println("Parcela: #" + (i+1));
            parcelas.get(i).getInfoParcelas();
        }
    }
}
