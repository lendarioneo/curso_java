package br.com.lendarioneo.excecoes.conta_bancaria.model.entities;

import br.com.lendarioneo.excecoes.conta_bancaria.model.exceptions.SaqueException;

public class ContaBancaria {
    private String numeroConta;
    private String cliente;
    private double saldo;
    private double limiteSaque;

    public ContaBancaria(String numeroConta, String cliente, double saldo, double limiteSaque) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public void depositar(double valor) throws SaqueException {
        if (valor <= 0.0){
            throw new SaqueException("Valor informado é negativo ou zero. Tente novamente");
        }
        saldo += valor;
    }

    public void sacar (double valor) throws SaqueException {
        if (valor > saldo){
            throw new SaqueException("O Valor do saque excede ao valor do saldo atual: " + saldo + ". Tente novamente.");
        }

        if (valor > limiteSaque){
            throw new SaqueException("O valor do saque não pode ser maior do que o limite para saque: " + limiteSaque);
        }
        saldo -= valor;
    }

    public void exibirInfo(){
        System.out.println("Nome do cliente: " + cliente +
                           "\nNumero da conta: " + numeroConta +
                           "\nSaldo: " + saldo +
                           "\nLimite para saque: " + limiteSaque);
    }
}
