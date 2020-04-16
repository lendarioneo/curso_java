package br.com.lendarioneo.lambda.predicate;

import java.util.function.Predicate;

public class ProdutctPredicate implements Predicate<Product> {

    @Override
    public boolean test(Product product) {
        return product.getPrice() >= 100;
    }
}
