package br.com.lendarioneo.generics.print_service.service;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T> {
    private List<T> list = new ArrayList<>();

    public void addValue(T value){
            this.list.add(value);
    }

    public T first(){
        if (list.isEmpty()){
            throw new IllegalArgumentException("The list is empty.");
        }
        return list.get(0);
    }

    public void print(){
        System.out.print("[");
        if (!list.isEmpty()){
            System.out.print(list.get(0));
        }
        if (list.size() > 1){
            for (T value: list) {
                System.out.print(", " + value);
            }
        }
        System.out.print("]");
    }

}
