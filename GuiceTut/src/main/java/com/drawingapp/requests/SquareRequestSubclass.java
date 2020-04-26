package com.drawingapp.requests;

import com.drawingapp.services.DrawShape;

import javax.inject.Inject;

public class SquareRequestSubclass extends SquareRequest {

    @Inject
    public SquareRequestSubclass(DrawShape d) {
        super(d);
    }

    @Override
    public void makeRequest() {
        System.out.println("SquareRequestSubclass delegating to super class");
        super.makeRequest();
    }
}
