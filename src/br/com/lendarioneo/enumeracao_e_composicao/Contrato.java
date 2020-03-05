package br.com.lendarioneo.enumeracao_e_composicao;

import java.util.Date;

public class Contrato {
    private Date data;
    private double valorHora;
    private int horasTrabalhadas;

    public Contrato(Date data, double valorHora, int horasTrabalhadas) {
        this.data = data;
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double totalReceber(){
        return horasTrabalhadas * valorHora;
    }

    public Date getData() {
        return data;
    }

    public Contrato setData(Date data) {
        this.data = data;
        return this;
    }

    public double getValorHora() {
        return valorHora;
    }

    public Contrato setValorHora(double valorHora) {
        this.valorHora = valorHora;
        return this;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public Contrato setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
        return this;
    }
}
