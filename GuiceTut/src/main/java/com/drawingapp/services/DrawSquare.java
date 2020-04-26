package com.drawingapp.services;

import com.drawingapp.annotations.ColorValue;
import com.drawingapp.annotations.EdgeValue;

import javax.inject.Inject;

public class DrawSquare implements DrawShape {

    private Integer edge;
    private String color;

    @Inject
    public DrawSquare(@EdgeValue Integer edge, @ColorValue String color) { //Create annotations for variable that can be used for binding values to these variable by guice
        this.edge = edge;
        this.color = color;
    }

    public void draw() {
        System.out.println("Drawing square");
    }
}
