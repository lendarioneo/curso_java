package br.com.paulowalmeida.interfaces.aluguel_carros_com_interface.model.services;

public class TaxaAluguelBrasilService implements TaxaService{
    public double taxaAluguel(double valor){
        if (valor <= 100){
            return valor * 0.2;
        }
        else {
            return valor * 0.15;
        }
    }
}
