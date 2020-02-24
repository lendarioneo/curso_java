package br.com.paulowalmeida.heranca_e_polimorfismo.funcionarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewFuncionario {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int nFunc = 0;

        System.out.print("Entre com o numero de funcionarios: ");
        nFunc = scanner.nextInt();

        for (int i = 1; i <= nFunc; i++) {
            boolean terceirizado = false;
            System.out.println("Dados do funcionario #" + i);

            System.out.print("Empregado Terceirizado? (S/N): ");
            terceirizado = scanner.next().toUpperCase().charAt(0) == 'S';
            scanner.nextLine();

            System.out.print("Nome do funcionário: ");
            String nome = scanner.nextLine();

            System.out.print("Quantidade de horas: ");
            int horas = scanner.nextInt();

            System.out.print("Valor da horas: ");
            double valorHora = scanner.nextDouble();

            double despesaAdicional = 0.0;
            if (terceirizado){
                System.out.print("Valor da Despesa adicional: ");
               despesaAdicional = scanner.nextDouble();
            }

            funcionarios.add (terceirizado ?
                    new FuncionarioTerceirizado(nome, horas, valorHora, despesaAdicional) :
                    new Funcionario(nome, horas, valorHora)
            );
        }

        for ( Funcionario func : funcionarios) {
            System.out.println("Nome : " + func.getNome());
            System.out.printf("Pagamento: %.2f", func.pagamento());
            System.out.println("\n");
        }
    }
}
