package br.com.lendarioneo.generics.tipo_curinga_delimitado.model.entities;

import br.com.lendarioneo.generics.tipo_curinga_delimitado.model.interfaces.Shape;

public class Circle implements Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public Circle setRadius(Double radius) {
        this.radius = radius;
        return this;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
