package com.drawingapp.requests;

import com.drawingapp.services.DrawShape;

import javax.inject.Inject;

public class SquareRequest {
    DrawShape d;

    @Inject // this tells Guice to create the DrawShape according to the binding rules and pass it to constructor
    public SquareRequest(DrawShape d){
        System.out.println("Creating Square Request object");
        this.d = d;
    }

    public void makeRequest(){
        d.draw();
    }
}
