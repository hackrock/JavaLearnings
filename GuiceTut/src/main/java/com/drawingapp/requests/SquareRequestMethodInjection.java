package com.drawingapp.requests;

import com.drawingapp.services.DrawShape;

import javax.inject.Inject;

public class SquareRequestMethodInjection {
    /*
    No constructor is defined. When Guice instantiate this class, it will call the setter and instantiates the
    dependencies accordingly. This is method injection
     */
    DrawShape d;

    public void makeRequest(){
        d.draw();
    }

    @Inject
    public void setD(DrawShape d) {
        System.out.println("setD called ");
        this.d = d;
    }
}
