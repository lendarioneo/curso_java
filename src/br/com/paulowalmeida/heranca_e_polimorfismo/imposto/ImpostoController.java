package br.com.paulowalmeida.heranca_e_polimorfismo.imposto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImpostoController {
    private List<Pessoa> pessoas = new ArrayList<>();
    private int quantidadeDeclaracoes;

    public void setQuantidadeDeclaracoes() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantas declarações deseja registrar? ");
        this.quantidadeDeclaracoes = scanner.nextInt();
    }

    public void informarPessoas() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= quantidadeDeclaracoes; i++) {
            System.out.print("Qual o tipo da Pessoa #" + i + " (Fisica/Juridica)? ");
            String tipoPessoa = scanner.next().toUpperCase();
            scanner.nextLine();

            System.out.print("Qual o nome da Pessoa # "+ i + "? ");
            String nome = scanner.nextLine();

            System.out.print("Qual a renda anual? ");
            double rendaAnual = scanner.nextDouble();

            if (tipoPessoa.equals("FISICA")) {
                System.out.print("Qual foi o total de gasto com saúde? ");
                double gastosaude = scanner.nextDouble();
                pessoas.add(new PessoaFisica(nome, rendaAnual, gastosaude));
                scanner.nextLine();
                System.out.println();
            }

            else if (tipoPessoa.equals("JURIDICA")){
                System.out.print("Qual a quantidade de Empregados? ");
                int quantidadeEmpregados = scanner.nextInt();
                pessoas.add(new PessoaJuridica(nome, rendaAnual, quantidadeEmpregados));
                System.out.println();
            }
        }
    }

    public void exibirImpostos(){
        double somatoria = 0.0;

        for (Pessoa pessoa: pessoas) {
            System.out.println("Nome: " + pessoa.getNome() +
                               "\nRenda anual: " + pessoa.getRendaAnual() + "\n");
            somatoria += pessoa.calcularImposto();
        }
        System.out.printf("Arrecadação total com impostos é de R$ %.2f", somatoria);
    }

    public void executar(){
        this.setQuantidadeDeclaracoes();
        this.informarPessoas();
        this.exibirImpostos();
    }
}
