package br.com.lendarioneo.generics.delimitados.model.service;

import java.util.List;

public class CalculationService {

    /**
     * O <T> está informando ao método que o tipo que ele vai trabalhar é um T.
     * O extends Comparable<T> diz ao método que ele pode trabalhar com qualquer T,
     * desde que ele tenha implementado a interface Comparable.
     *
     * @param list
     * @param <T>
     * @return
     */
    public <T extends Comparable<? super T>> T max(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }
        T max = list.get(0);
        for (T value : list) {
            /* se for maior que zero, indica que o valor é maior que o max, ou seja, é o maior. */
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }
}
