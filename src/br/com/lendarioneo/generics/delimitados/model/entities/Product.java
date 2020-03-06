package br.com.lendarioneo.generics.delimitados.model.entities;

import org.jetbrains.annotations.NotNull;

public class Product implements Comparable<Product>{
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Product setPrice(Double price) {
        this.price = price;
        return this;
    }

    @Override
    public int compareTo(@NotNull Product other) {
        return price.compareTo(other.getPrice());
    }
}
