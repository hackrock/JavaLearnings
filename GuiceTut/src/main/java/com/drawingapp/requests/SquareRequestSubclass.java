package com.drawingapp.requests;

import com.drawingapp.annotations.Square;
import com.drawingapp.services.DrawShape;

import javax.inject.Inject;

public class SquareRequestSubclass extends SquareRequest {

    @Inject
    public SquareRequestSubclass(@Square DrawShape d) {
        super(d);
    }

    @Override
    public void makeRequest() {
        System.out.println("SquareRequestSubclass delegating to super class");
        super.makeRequest();
    }
}
