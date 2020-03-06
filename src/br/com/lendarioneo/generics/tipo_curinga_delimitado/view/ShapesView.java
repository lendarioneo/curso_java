package br.com.lendarioneo.generics.tipo_curinga_delimitado.view;

import br.com.lendarioneo.generics.tipo_curinga_delimitado.model.entities.Circle;
import br.com.lendarioneo.generics.tipo_curinga_delimitado.model.entities.Retangle;
import br.com.lendarioneo.generics.tipo_curinga_delimitado.model.interfaces.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapesView {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(2.0));
        shapes.add(new Retangle(3.0, 2.0));

        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle(2.0));
        circles.add(new Circle(3.0));

        System.out.println("Total area: " + totalArea(circles));
    }

    /* <? extends Shape> indica ao método que a list pode ser Shape ou qualquer subtipo de Shape.
    * Este é o curinga delimitado.
    * Contudo essa implementação não permite também a adição de novos valores, apenas a leitura. */
    private static double totalArea(List<? extends Shape> list) {
        double sum = 0.0;
        for (Shape shape: list){
            sum += shape.area();
        }
        return sum;
    }
}
