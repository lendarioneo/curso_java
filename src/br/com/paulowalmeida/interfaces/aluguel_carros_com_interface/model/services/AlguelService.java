package br.com.paulowalmeida.interfaces.aluguel_carros_com_interface.model.services;

import br.com.paulowalmeida.interfaces.aluguel_carros_com_interface.model.entities.AluguelVeiculo;
import br.com.paulowalmeida.interfaces.aluguel_carros_com_interface.model.entities.Fatura;

public class AlguelService {
    private Double precoPorHora;
    private Double precoPorDia;
    private TaxaService taxaService;

    public AlguelService(Double precoPorHora, Double precoPorDia, TaxaService taxaService) {
        this.precoPorHora = precoPorHora;
        this.precoPorDia = precoPorDia;
        this.taxaService = taxaService;
    }

    public Double getPrecoPorHora() {
        return precoPorHora;
    }

    public AlguelService setPrecoPorHora(Double precoPorHora) {
        this.precoPorHora = precoPorHora;
        return this;
    }

    public Double getPrecoPorDia() {
        return precoPorDia;
    }

    public AlguelService setPrecoPorDia(Double precoPorDia) {
        this.precoPorDia = precoPorDia;
        return this;
    }

    public TaxaService getTaxaAluguelBrasilService() {
        return taxaService;
    }

    public AlguelService setTaxaAluguelBrasilService(TaxaAluguelBrasilService taxaAluguelBrasilService) {
        this.taxaService = taxaAluguelBrasilService;
        return this;
    }

    public void processarFatura(AluguelVeiculo aluguelVeiculo){
        /*pega em milissegundos os tempos*/
        Long instante1 = aluguelVeiculo.getInicio().getTime();
        Long instante2 = aluguelVeiculo.getTermino().getTime();

        /*milissegundos para segundos, segundos para minutos e minutos para horas*/
        double horas = (double) (instante2 - instante1) / 1000 / 60 / 60;

        double pagamentoBase;
        if (horas <= 12.0){
            pagamentoBase = Math.ceil(horas) * this.precoPorHora;
        }
        else {
            pagamentoBase = Math.ceil(horas / 24) * this.precoPorDia;
        }

        double taxaServico = this.taxaService.taxaAluguel(pagamentoBase);
        aluguelVeiculo.setFatura(new Fatura(pagamentoBase, taxaServico));
        }
}