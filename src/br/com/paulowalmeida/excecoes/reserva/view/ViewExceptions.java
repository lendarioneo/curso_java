package view;

import model.entidades.Reserva;
import model.exceptions.EntidadesException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewExceptions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Num. Quarto: ");
            int numQuarto = scanner.nextInt();

            System.out.print("Check-In: ");
            Date checkIn = simpleDateFormat.parse(scanner.next());

            System.out.print("Check-Out: ");
            Date checkOut = simpleDateFormat.parse(scanner.next());

            Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);

            System.out.println("Reserva: " + reserva);
            System.out.println();
            System.out.println("Entre com as informações para atualizar os dados:");

            System.out.print("Check-In: ");
            checkIn = simpleDateFormat.parse(scanner.next());

            System.out.print("Check-Out: ");
            checkOut = simpleDateFormat.parse(scanner.next());

            reserva.atualizarDatas(checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
        }
        catch (ParseException parseException){
            System.out.println("Erro: Data Inválida.");
        }

        catch (EntidadesException e){
            System.out.println("Erro: " + e.getMessage());
        }

        catch (InputMismatchException e){
            System.out.println("Erro: Entrada inválida!");
        }
    }
}
