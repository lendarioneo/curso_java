package br.com.lendarioneo.arquivos.manipulando_pastas_file;

import java.io.File;
import java.util.Scanner;

public class ExemploFilePastas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o diretório: ");
        String strPath = scan.nextLine();
        File path = new File(strPath);
        File[] folders = path.listFiles(File :: isDirectory);
        System.out.println("Pastas: ");
        for (File folder : folders) {
            System.out.println(folder);
        }

        File[] files = path.listFiles(File:: isFile);
        System.out.println("Arquivos: ");
        for (File file : files) {
            System.out.println(file);
        }

        boolean sucesso = new File(strPath + "\\tempJava").mkdir();
        System.out.println("Criou com sucesso o novo diretorio? " + sucesso);
    }
}
