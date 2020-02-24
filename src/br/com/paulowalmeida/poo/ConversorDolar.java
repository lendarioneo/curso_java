package br.com.paulowalmeida.poo;

import javax.swing.*;

public class ConversorDolar {
    private double cotacaoDolar;
    private double valorCompra;
    private final double taxaIOF = 6.0;

    private double calculaValorEmReal(double cotacaoDolar, double valorCompra) {
        double valor = cotacaoDolar * valorCompra;
        double valorTaxa = valor * taxaIOF / 100;
        return valor + valorTaxa;
    }

    public static void main(String[] args) {
        ConversorDolar conversorDolar = new ConversorDolar();
        double cotacaoDolar = Double.parseDouble(JOptionPane.showInputDialog("Qual a cotação do Dolar?"));
        double valorCompra = Double.parseDouble(JOptionPane.showInputDialog("Qual o total de dolar que deseja ser comprado?"));
        double valorASerPago = conversorDolar.calculaValorEmReal(cotacaoDolar, valorCompra);
        JOptionPane.showMessageDialog(null, "O total que deve ser pago em reais é de " + valorASerPago);
    }
}
