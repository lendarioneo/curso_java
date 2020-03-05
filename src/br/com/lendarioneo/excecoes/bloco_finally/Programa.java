package br.com.lendarioneo.excecoes.bloco_finally;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        File file = new File("C:\\temp\\in.txt");
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Erro ao abrir o arquivo. Msg: "+ e.getMessage());
        }
        finally {
            if (scanner != null){
                scanner.close();
            }
            System.out.println("Bloco Finally foi executado");
        }
        System.out.println("====== Fim do programa. ======");
    }
}
