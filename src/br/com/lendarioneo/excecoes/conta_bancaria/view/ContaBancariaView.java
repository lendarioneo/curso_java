package br.com.lendarioneo.excecoes.conta_bancaria.view;

import br.com.lendarioneo.excecoes.conta_bancaria.model.entities.ContaBancaria;
import br.com.lendarioneo.excecoes.conta_bancaria.model.exceptions.SaqueException;

import java.util.Scanner;

public class ContaBancariaView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Qual o numero da conta? ");
            String numeroConta = scanner.next();
            scanner.nextLine();

            System.out.print("Qual o nome do cliente? ");
            String cliente = scanner.nextLine();

            System.out.print("Qual o Saldo Inicial? ");
            double saldo = scanner.nextDouble();

            System.out.print("Qual o Limite de Saque? ");
            double limiteSaque = scanner.nextDouble();

            ContaBancaria conta = new ContaBancaria(numeroConta, cliente, saldo, limiteSaque);
            conta.exibirInfo();

            System.out.println("Qual o valor do seu deposito? ");
            double valorDep = scanner.nextDouble();
            conta.depositar(valorDep);
            conta.exibirInfo();

            System.out.println("Qual o valor do seu saque? ");
            double valorSac = scanner.nextDouble();
            conta.sacar(valorSac);
            conta.exibirInfo();

        } catch (SaqueException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Fim da execução!");
    }
}
