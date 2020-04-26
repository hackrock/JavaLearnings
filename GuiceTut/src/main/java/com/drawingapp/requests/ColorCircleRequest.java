package com.drawingapp.requests;

import com.drawingapp.annotations.Circle;
import com.drawingapp.annotations.Square;
import com.drawingapp.sample3partyLib.ColorShape;

import javax.inject.Inject;

public class ColorCircleRequest {
    @Inject
   // private ColorShape c; // We need to tell guice what color implementation to use. This is enough if there is only one implementation of ColorShape.
    // When you have multiple implementation like ColorSquare ColorCircle you need to call that out using annotations
    private @Circle ColorShape c;

    public void color(){
        this.c.color();
    }

}
