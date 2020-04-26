package com.drawingapp.services;

import com.drawingapp.annotations.ColorValue;
import com.drawingapp.annotations.EdgeValue;

import javax.inject.Inject;

public class DrawSquare implements DrawShape {

    private Integer edge;
    private String color;

    @Inject
    public DrawSquare(Integer edge, String color) {
        this.edge = edge;
        this.color = color;
    }

    public void draw() {
        System.out.println("Drawing square");
    }
}
