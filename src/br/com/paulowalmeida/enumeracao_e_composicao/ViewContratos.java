package br.com.paulowalmeida.enumeracao_e_composicao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ViewContratos {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        Trabalhador trabalhador = new Trabalhador();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Qual o nome do departamento: ");
        trabalhador.setDepartamento(scanner.nextLine());

        System.out.println("Entre com os dados do funcionario: ");
        System.out.print("Nome: ");
        trabalhador.setNome(scanner.nextLine());

        System.out.print("Nível: ");
        trabalhador.setNivel(NivelExperiencia.valueOf(scanner.nextLine().toUpperCase()));

        System.out.print("Salário Base: ");
        trabalhador.setSalarioBase(scanner.nextDouble());

        System.out.print("Quantos Contratos para este trabalhador? ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do contrato #" + i + ": ");
            System.out.print("Data: (ex: DD/MM/AAAAA) : ");
            Date dataContrato = simpleDateFormat.parse(scanner.next());

            System.out.print("Valor da Hora: ");
            double valorHora = scanner.nextDouble();

            System.out.print("Quantidade de Horas: ");
            int quantidadeHoras = scanner.nextInt();

            Contrato contrato =  new Contrato(dataContrato, valorHora, quantidadeHoras);
            trabalhador.adicionarContrato(contrato);
        }

        System.out.println();
        System.out.print("Entre com o ano e mes que deve ser calculado (MM/AAAA): ");
        String periodo = scanner.next();

        int mes = Integer.parseInt(periodo.substring(0, 2));
        int ano = Integer.parseInt(periodo.substring(3));

        System.out.println("Nome do empregado: " + trabalhador.getNome());
        System.out.println("Departamento do empregado: " + trabalhador.getDepartamento());
        System.out.println("Nivel do empregado: " + trabalhador.getNivel());
        System.out.println("Salario Base do empregado: " + trabalhador.getSalarioBase());
        System.out.println("A renda do empregado no periodo " + mes +"/"+ ano + " é de: R$ " + trabalhador.calcularRenda(ano, mes));
    }
}
