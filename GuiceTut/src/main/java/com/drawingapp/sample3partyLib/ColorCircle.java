package com.drawingapp.sample3partyLib;

// Lets image this to be provided by a 3rd library and you cannot change the implementation.
// How can we use guice without adding Inject or annotations in this file ?

public class ColorCircle implements ColorShape {

    private String color;

    public ColorCircle(String color) {
        this.color = color;
    }

    public void color() {
        System.out.println("Coloring Circle: " + this.color);
    }
}
