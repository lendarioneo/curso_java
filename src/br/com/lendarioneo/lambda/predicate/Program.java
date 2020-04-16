package br.com.lendarioneo.lambda.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Program {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        //list.removeIf(new ProdutctPredicate());

        //list.removeIf(Product::staticProductPredicate);

        //list.removeIf(Product::nonStaticProductPredicate);

        Predicate<Product> productPredicate = (p -> p.getPrice() >= 100);
        list.removeIf(productPredicate);

        for (Product product : list) {
            System.out.println(product);
        }
    }
}
