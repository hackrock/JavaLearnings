package com.drawingapp.sample3partyLib;

// Lets image this to be provided by a 3rd library and you cannot change the implementation.
// How can we use guice without adding Inject or annotations in this file ?

public class ColorSquare implements ColorShape {

    private String color;

    public ColorSquare(String color) {
        this.color = color;
    }

    public void color() {
        System.out.println("Coloring Square: " + this.color);
    }
}
