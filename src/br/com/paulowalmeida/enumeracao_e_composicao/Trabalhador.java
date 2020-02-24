package br.com.paulowalmeida.enumeracao_e_composicao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {
    private String nome;
    private NivelExperiencia nivel;
    private double salarioBase;
    private String departamento;
    private List<Contrato> contratos = new ArrayList<>();;

    public Trabalhador() {
    }

    public String getNome() {
        return nome;
    }

    public Trabalhador setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public NivelExperiencia getNivel() {
        return nivel;
    }

    public Trabalhador setNivel(NivelExperiencia nivel) {
        this.nivel = nivel;
        return this;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public Trabalhador setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
        return this;
    }

    public String getDepartamento() {
        return departamento;
    }

    public Trabalhador setDepartamento(String departamento) {
        this.departamento = departamento;
        return this;
    }

    public void adicionarContrato(Contrato contrato){
        this.contratos.add(contrato);
    }

    public boolean removerContratio(int index){
        return this.contratos.remove(index) != null;
    }

    public double calcularRenda (int ano, int mes){
        double soma = salarioBase;
        Calendar calendar = Calendar.getInstance();
        for (Contrato c: contratos) {
            calendar.setTime(c.getData());
            int c_ano = calendar.get(Calendar.YEAR);
            int c_mes = calendar.get(Calendar.MONTH) + 1;
            if (c_ano == ano && c_mes == mes){
                soma += c.totalReceber();
            }
        }
        return soma;
    }
}
