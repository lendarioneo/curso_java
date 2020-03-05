package br.com.lendarioneo.excecoes.pilha_de_metodos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        metodo1();
        System.out.println("Fim do programa");
    }

    public static void metodo1(){
        System.out.println("==== Inicio do Método 1 ====");
        metodo2();
        System.out.println("==== Fim do Método 1 ====");
    }

    public static void metodo2(){
        System.out.println("==== Inicio do Método 2 ====");
        Scanner scanner = new Scanner(System.in);
        try {
            String[] vetor = scanner.nextLine().split(" ");
            int posicao = scanner.nextInt();
            System.out.println("Nome: " + vetor[posicao]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Posição Inválida!");
            e.printStackTrace();
            scanner.next();
        }

        catch (InputMismatchException e){
            System.out.println("Entrada inválida!");
        }

        scanner.close();
        System.out.println("==== Fim do Método 2 ====");
    }
}
