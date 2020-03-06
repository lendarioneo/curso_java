package br.com.lendarioneo.generics.tipos_curinga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExemploCuringa {
    public static void main(String[] args) {
        /* Listas do tipo Curinga não fazem adições de novos valores a lista. */
        //List<?> listCuringa = new ArrayList<>();
        List<Integer> integers = Arrays.asList(5, 2, 10);
        List<String> strings = Arrays.asList("Maria", "Pedro", "Paulo");
        //listCuringa = integers;
        print(integers);
        print(strings);
    }

    public static void print(List<?> list){
        for (Object o: list){
            System.out.println("Value: " + o);
        }
    }
}
