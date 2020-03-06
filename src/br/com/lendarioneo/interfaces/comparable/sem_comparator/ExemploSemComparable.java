package br.com.lendarioneo.interfaces.comparable.sem_comparator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExemploSemComparable {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        String path = "c:\\temp\\nomes.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String name = bufferedReader.readLine();
            while (name != null) {
                names.add(name);
                name = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Collections.sort(names);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
