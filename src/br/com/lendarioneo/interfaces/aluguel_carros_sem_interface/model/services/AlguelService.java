package br.com.lendarioneo.interfaces.aluguel_carros_sem_interface.model.services;

import br.com.lendarioneo.interfaces.aluguel_carros_sem_interface.model.entities.AluguelVeiculo;
import br.com.lendarioneo.interfaces.aluguel_carros_sem_interface.model.entities.Fatura;

public class AlguelService {
    private Double precoPorHora;
    private Double precoPorDia;
    private TaxaAluguelBrasilService taxaAluguelBrasilService;

    public AlguelService(Double precoPorHora, Double precoPorDia, TaxaAluguelBrasilService taxaAluguelBrasilService) {
        this.precoPorHora = precoPorHora;
        this.precoPorDia = precoPorDia;
        this.taxaAluguelBrasilService = taxaAluguelBrasilService;
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

    public TaxaAluguelBrasilService getTaxaAluguelBrasilService() {
        return taxaAluguelBrasilService;
    }

    public AlguelService setTaxaAluguelBrasilService(TaxaAluguelBrasilService taxaAluguelBrasilService) {
        this.taxaAluguelBrasilService = taxaAluguelBrasilService;
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

        double taxaServico = this.taxaAluguelBrasilService.taxaAlguel(pagamentoBase);
        aluguelVeiculo.setFatura(new Fatura(pagamentoBase, taxaServico));
        }
}