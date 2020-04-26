package com.drawingapp.requests;

import com.drawingapp.annotations.Square;
import com.drawingapp.services.DrawShape;

import javax.inject.Inject;
import javax.inject.Named;

public class CircleRequest {

    @Inject
    private @Named("Circle") DrawShape d;

    public void makeRequest(){
        d.draw();
    }
}
