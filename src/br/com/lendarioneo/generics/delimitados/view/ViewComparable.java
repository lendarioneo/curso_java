package br.com.lendarioneo.generics.delimitados.view;

import br.com.lendarioneo.generics.delimitados.model.entities.Product;
import br.com.lendarioneo.generics.delimitados.model.service.CalculationService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewComparable {
    public static void main(String[] args) {
        String path = "c:\\temp\\eletronicos.csv";
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String[] fields = reader.readLine().split(",");
            while (reader.readLine() != null) {
                products.add(new Product(fields[0], Double.parseDouble(fields[1])));
                fields = reader.readLine().split(",");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        CalculationService service = new CalculationService();
        Product product = service.max(products);
        System.out.println("Max: " + product.getName() + "," + String.format("%.2f", product.getPrice()));
    }
}
