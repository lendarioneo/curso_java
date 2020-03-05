package br.com.lendarioneo.interfaces.aluguel_carros_sem_interface.model.entities;

public class Veiculo {
    private String modelo;

    public Veiculo() {
    }

    public Veiculo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public Veiculo setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }
}
