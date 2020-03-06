package br.com.lendarioneo.interfaces.comparable.com_comparator.model.view;

import br.com.lendarioneo.interfaces.comparable.com_comparator.model.entities.Empregado;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExemploComparable {
    public static void main(String[] args) {
        List<Empregado> empregados = new ArrayList<>();
        String path = "c:\\temp\\empregados.csv";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String empregado = bufferedReader.readLine();
            while (empregado != null) {
                String[] campos = empregado.split(",");
                empregados.add(new Empregado(campos[0], Double.parseDouble(campos[1])));
                empregado = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Collections.sort(empregados);
        for (Empregado empregado: empregados) {
            System.out.println(empregado.getNome() + "," + empregado.getSalario());
        }
    }
}
