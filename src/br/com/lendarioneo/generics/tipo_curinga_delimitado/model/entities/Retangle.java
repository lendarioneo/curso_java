package br.com.lendarioneo.generics.tipo_curinga_delimitado.model.entities;

import br.com.lendarioneo.generics.tipo_curinga_delimitado.model.interfaces.Shape;

public class Retangle implements Shape {

    private Double width;
    private Double height;

    public Retangle(Double width, Double height) {
        this.width = width;
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public Retangle setWidth(Double width) {
        this.width = width;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public Retangle setHeight(Double height) {
        this.height = height;
        return this;
    }

    @Override
    public double area() {
        return width * height;
    }
}
