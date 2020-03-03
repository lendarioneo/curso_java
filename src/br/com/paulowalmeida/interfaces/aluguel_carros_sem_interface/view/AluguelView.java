package br.com.paulowalmeida.interfaces.aluguel_carros_sem_interface.view;

import br.com.paulowalmeida.interfaces.aluguel_carros_sem_interface.model.entities.AluguelVeiculo;
import br.com.paulowalmeida.interfaces.aluguel_carros_sem_interface.model.entities.Veiculo;
import br.com.paulowalmeida.interfaces.aluguel_carros_sem_interface.model.services.AlguelService;
import br.com.paulowalmeida.interfaces.aluguel_carros_sem_interface.model.services.TaxaAluguelBrasilService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class AluguelView {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:ss");

        System.out.println("Entre com os dados do Aluguel:");

        System.out.print("Modelo do Carro: ");
        String modeloCarro = scanner.nextLine();

        System.out.print("Data da retirada do Carro (dd/mm/aaaa hh:ss): ");
        Date inicioAluguel = simpleDateFormat.parse(scanner.nextLine());

        System.out.print("Data da devolução do Carro (dd/mm/aaaa hh:ss): ");
        Date terminoAluguel = simpleDateFormat.parse(scanner.nextLine());

        AluguelVeiculo aluguelVeiculo = new AluguelVeiculo(inicioAluguel, terminoAluguel, new Veiculo(modeloCarro));

        System.out.print("Entre com o preço por hora: ");
        double precoHora = scanner.nextDouble();

        System.out.print("Entre com o preço por dia: ");
        double precoDia = scanner.nextDouble();

        AlguelService alguelService = new AlguelService(precoHora, precoDia, new TaxaAluguelBrasilService());
        alguelService.processarFatura(aluguelVeiculo);

        System.out.print("Fatura: ");
        System.out.println("Pagamento Básico: " + String.format("%.2f", aluguelVeiculo.getFatura().getPagamentoBase()));
        System.out.println("Taxa: " + String.format("%.2f", aluguelVeiculo.getFatura().getTaxa()));
        System.out.println("Total Pagamento: " + String.format("%.2f", aluguelVeiculo.getFatura().pagamentoTotal()));
        scanner.close();
    }
}
