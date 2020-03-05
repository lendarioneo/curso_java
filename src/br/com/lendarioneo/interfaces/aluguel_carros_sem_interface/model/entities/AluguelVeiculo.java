package br.com.lendarioneo.interfaces.aluguel_carros_sem_interface.model.entities;

import java.util.Date;

public class AluguelVeiculo {
    private Date inicio;
    private Date termino;
    private Fatura fatura;
    private Veiculo veiculo;

    public AluguelVeiculo(Date inicio, Date termino, Veiculo veiculo) {
        this.inicio = inicio;
        this.termino = termino;
        this.veiculo = veiculo;
    }

    public AluguelVeiculo() {
    }

    public Date getInicio() {
        return inicio;
    }

    public AluguelVeiculo setInicio(Date inicio) {
        this.inicio = inicio;
        return this;
    }

    public Date getTermino() {
        return termino;
    }

    public AluguelVeiculo setTermino(Date termino) {
        this.termino = termino;
        return this;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public AluguelVeiculo setFatura(Fatura fatura) {
        this.fatura = fatura;
        return this;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public AluguelVeiculo setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
        return this;
    }
}
