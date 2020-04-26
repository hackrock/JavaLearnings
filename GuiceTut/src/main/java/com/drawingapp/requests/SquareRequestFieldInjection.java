package com.drawingapp.requests;

import com.drawingapp.services.DrawShape;

import javax.inject.Inject;

public class SquareRequestFieldInjection {
    /*
    When guice instantiate this class it will instantiate the fields having the inject annotation
     */
    @Inject
    DrawShape d;

    public void makeRequest(){
        d.draw();
    }

}
