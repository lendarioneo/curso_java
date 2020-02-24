package br.com.paulowalmeida.excecoes.conceitual;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String[] vetor = scanner.nextLine().split(" ");
            int posicao = scanner.nextInt();
            System.out.println("Nome: " + vetor[posicao]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Posição Inválida!");
        }

        catch (InputMismatchException e){
            System.out.println("Entrada inválida!");
        }
        System.out.println("Fim do programa");
        scanner.close();
    }
}
