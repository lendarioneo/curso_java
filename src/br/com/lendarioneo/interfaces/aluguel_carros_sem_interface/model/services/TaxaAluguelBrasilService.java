package br.com.lendarioneo.interfaces.aluguel_carros_sem_interface.model.services;

public class TaxaAluguelBrasilService {
    public double taxaAlguel(double valor){
        if (valor <= 100){
            return valor * 0.2;
        }
        else {
            return valor * 0.15;
        }
    }
}
