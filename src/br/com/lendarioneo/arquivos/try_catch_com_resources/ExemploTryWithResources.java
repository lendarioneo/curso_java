package br.com.lendarioneo.arquivos.try_catch_com_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Exemplo de como utilizar o try-with-resources para um melhor uso de recursos que podem gerar um IOException.
 */
public class ExemploTryWithResources {
    public static void main(String[] args) {
        String path = "c:\\temp\\in.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
