package br.com.paulowalmeida.arquivos.firewriter_e_bufferedwriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExemploFireWriter {
    public static void main(String[] args) {
        String path = "c:\\temp\\novo_arquivo.txt";
        String[] linhas = new String[] {"Bom dia", "Boa tarde", "Boa noite"};

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            for (String linha: linhas) {
                writer.write(linha);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
