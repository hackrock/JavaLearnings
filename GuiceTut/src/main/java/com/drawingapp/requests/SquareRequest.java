package com.drawingapp.requests;

import com.drawingapp.annotations.Square;
import com.drawingapp.services.DrawShape;

import javax.inject.Inject;

public class SquareRequest {
    DrawShape d;

    @Inject // this tells Guice to create the DrawShape according to the binding rules and pass it to constructor
    public SquareRequest(@Square DrawShape d){ // Now that DrawShape is implemented by DrawCircle and DrawSquare we must explicitly call it out for guice
        System.out.println("Creating Square Request object");
        this.d = d;
    }

    public void makeRequest(){
        d.draw();
    }

    public DrawShape getDrawShape() {
        //return the drawshape object instance
        return this.d;
    }
}
