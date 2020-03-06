package br.com.lendarioneo.interfaces.comparable.com_comparator.model.entities;

import org.jetbrains.annotations.NotNull;

public class Empregado implements Comparable<Empregado> {
    private String nome;
    private Double salario;

    public Empregado(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public Empregado setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Double getSalario() {
        return salario;
    }

    public Empregado setSalario(Double salario) {
        this.salario = salario;
        return this;
    }

    @Override
    public int compareTo(@NotNull Empregado o) {
        return -this.salario.compareTo(o.getSalario());
    }
}
