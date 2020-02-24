package br.com.paulowalmeida.encapsulamento;

public class Conta {
    private String nomeTitular;
    private int numeroConta;
    private double saldo;

    public Conta(String nomeTitular, int numeroConta, double saldo) {
        this.nomeTitular = nomeTitular;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public Conta() {
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public Conta setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
        return this;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Conta setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
        return this;
    }

    public Conta setSaldo(double saldo) {
        this.saldo = saldo;
        return this;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean realizarSaque(double valor) {
        double taxaSaque = 5.0;
        if (!verificarValor((valor + taxaSaque), "saque")){
            return false;
        }
        this.saldo -= valor + taxaSaque;
        return true;
    }

    public boolean fazerDeposito(double valor) {
        if (!verificarValor(valor, "deposito")){
            return false;
        }
        this.saldo += valor;
        return true;
    }

    private boolean verificarValor(double valor, String operacao) {
        if (operacao.equalsIgnoreCase("saque") && valor <= 0 || valor > this.saldo) {
            return false;
        }
        else if (operacao.equalsIgnoreCase("deposito") && valor <= 0) {
            return false;
        }
        return true;
    }
}
