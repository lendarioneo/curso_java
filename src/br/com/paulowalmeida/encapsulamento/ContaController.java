package br.com.paulowalmeida.encapsulamento;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.ArrayList;

public class ContaController {

    private ArrayList<Conta> contas;

    public ContaController() {
        contas = new ArrayList<>();
    }

    public void exibirMenu(){
        String opcaoMenu;
        int opcaoMenuPrincipal = 0;
        do {
            opcaoMenu = JOptionPane.showInputDialog("Menu Principal:" +
                            "\n1 - Abrir Conta" +
                            "\n2 - Acessar Conta" +
                            "\n3 - Sair");

            opcaoMenuPrincipal = opcaoMenu.equals("") ? 0 : Integer.parseInt(opcaoMenu);
            switch (opcaoMenuPrincipal) {
                case 1:
                    this.abrirConta();
                    break;
                case 2:
                    this.acessarConta();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Até mais!");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
            }
        } while (opcaoMenuPrincipal != 3);
    }

    private void exibirOperacoesConta(Conta conta) {
        int opcoesMenuConta = 1;
        String opcaoConta;
        do {
            opcaoConta = JOptionPane.showInputDialog("Escolha uma das opções:" +
                            "\n1 - Sacar" +
                            "\n2 - Depositar" +
                            "\n3 - Ver Saldo" +
                            "\n4 - Ir para o Menu Principal");
            opcoesMenuConta = opcaoConta.equals("") ? 0 : Integer.parseInt(opcaoConta) ;
            double valor = 0.0;
            switch (opcoesMenuConta) {
                case 1:
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor do saque?"));
                    while (!conta.realizarSaque(valor)) {
                        valor = Double.parseDouble(JOptionPane.showInputDialog("Valor de Saque inválido. Tente outro."));
                    }
                    this.exibirMensagem(conta, valor, "Saque");
                    valor = 0.0;
                    break;

                case 2:
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor do deposito?"));
                    while (!conta.fazerDeposito(valor)) {
                        valor = Double.parseDouble(JOptionPane.showInputDialog("Valor de Depósito inválido. Tente outro."));
                    }
                    this.exibirMensagem(conta, valor, "Deposito");
                    valor = 0.0;
                    break;

                case 3:
                    this.exibirMensagem(conta, valor, "Ver Saldo");
                    valor = 0.0;
                    break;

                case 4:
                    this.exibirMenu();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
            }
        } while (opcoesMenuConta >= 1 || opcoesMenuConta <= 4);
    }


    private void abrirConta() {
        Conta novaConta = new Conta();
        novaConta.setNomeTitular(JOptionPane.showInputDialog("Nome do Titular"));
        while (novaConta.getNomeTitular().isEmpty()){
            novaConta.setNomeTitular(JOptionPane.showInputDialog("Voce precisa digitar o nome do titular."));
        }

        novaConta.setNumeroConta(Integer.parseInt(JOptionPane.showInputDialog("Número da conta corrente")));
        while (novaConta.getNumeroConta() == 0) {
            novaConta.setNumeroConta(Integer.parseInt(JOptionPane.showInputDialog("Voce precisa digitar um número válido.")));
        }

        int temDepositoInicial = Integer.parseInt(JOptionPane.showInputDialog("Deseja Realizar depósito inicial? (1-Sim / 2-Não)"));
        novaConta.setSaldo(0);
        if (temDepositoInicial == 1){
            novaConta.setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Qual o valor do depósito inicial?")));
        }

        this.contas.add(novaConta);
        this.exibirMensagem(novaConta, novaConta.getSaldo(), "Nova Conta");
    }


    private void acessarConta() {
        boolean ehNumeroConta = false;
        int opcaoErro = 0;
        Conta contaRecuperada = null;

        while (!ehNumeroConta) {
            int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Qual o Número da Conta?"));
            for (int i = 0; i < contas.size(); i++){
                Conta contaIteracao = this.contas.get(i);
                if (contaIteracao.getNumeroConta() == numeroConta){
                    contaRecuperada = contaIteracao;
                    ehNumeroConta = true;
                }
            }

            if (!ehNumeroConta){
                opcaoErro = Integer.parseInt(JOptionPane.showInputDialog("Não foi possivel encontrar a conta.\n" +
                        "\n1 - Tentar novamente" +
                        "\n2 - Sair"));

                if (opcaoErro == 2){
                    ehNumeroConta = true;
                    this.exibirMenu();
                }
            }
        }

        this.exibirOperacoesConta(contaRecuperada);
    }


    private void exibirMensagem(Conta conta, double valor, @NotNull String operacao) {
        String mensagem = "";

        if (operacao.equalsIgnoreCase("Nova Conta")) {
            mensagem += "Conta Criada com Sucesso!";
        }

        if (operacao.equalsIgnoreCase("Nova Conta") || operacao.equalsIgnoreCase("Ver Saldo")){
            mensagem +="\nDados da Conta:" +
                       "\nTitular: " + conta.getNomeTitular() +
                       "\nNumero da Conta: " + conta.getNumeroConta() +
                       "\nSaldo: " + valor;
        }

        else if(!operacao.equalsIgnoreCase("Nova Conta")) {
            mensagem += "Operação realizada com sucesso!" +
                        "\nInformações: ";
        }

        if (operacao.equalsIgnoreCase("Saque")) {
            mensagem += "\nValor do Saque: " + valor +
                        "\nTaxa: R$ 5.00 ";
        }

        else if (operacao.equalsIgnoreCase("Deposito")) {
            mensagem += "\nValor do Depósito: " + valor;
        }

        if (!operacao.equalsIgnoreCase("Nova conta") && !operacao.equalsIgnoreCase("Ver Saldo")) {
            mensagem += "\nSaldo após operação: " + conta.getSaldo();
        }

        JOptionPane.showMessageDialog(null, mensagem);
    }
}
