package com.drawingapp.providers;

import com.drawingapp.annotations.CircleColor;
import com.drawingapp.sample3partyLib.ColorCircle;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ColorCircleProvider implements Provider<ColorCircle> {

    // You can add a construtor for this provider and make guice use it by annotating it with inject
    // Then initialize the require arguments that is needed for creating ColorCircle here. The arguments can then be set in the guice bindings

    private String color;

    @Inject
    public ColorCircleProvider(@CircleColor String color) {
        this.color = color;
    }

    // Provider interface has one method get which returns the instance of the type T
    // implement it here
    public ColorCircle get() {
//        ColorCircle c = new ColorCircle("GREEN"); //This is one way of passing the args but not recommended because changing color would involve change this code
        ColorCircle c = new ColorCircle(this.color);
        return c;
    }
}
