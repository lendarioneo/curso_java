package br.com.lendarioneo.generics.print_service.view;

import br.com.lendarioneo.generics.print_service.service.PrintService;

public class ViewGenerics {
    public static void main(String[] args) {
        PrintService<Integer> numbers = new PrintService<>();
        numbers.addValue(10);
        numbers.addValue(20);
        numbers.addValue(30);
        numbers.addValue(40);
        numbers.addValue(50);
        numbers.addValue(60);

        System.out.println("First number in list: " + numbers.first());
        numbers.print();
    }
}
