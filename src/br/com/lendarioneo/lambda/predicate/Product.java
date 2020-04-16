package br.com.lendarioneo.lambda.predicate;

public class Product {
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

    public static boolean staticProductPredicate(Product p){
        return p.getPrice() >= 100;
    }

    public boolean nonStaticProductPredicate(){
        return this.price >= 100;
    }

    @Override
    public String toString() {
        return name + ", " + String.format("%.2f", price);
    }
}
