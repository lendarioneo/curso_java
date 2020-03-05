package br.com.lendarioneo.arquivos.info_url_arquivo;

import java.io.File;
import java.util.Scanner;

public class ExemploInfoURLArquivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o caminho do arquivo: ");
        String strPath = scanner.nextLine();
        File path = new File(strPath);
        System.out.println("Nome Arquivo: " + path.getName());
        System.out.println("Caminho: " + path.getParent());
        System.out.println("Caminho absoluto: " + path.getPath());
    }
}
