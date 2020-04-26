package com.drawingapp;

import com.drawingapp.module.AppModule;
import com.drawingapp.requests.SquareRequest;
import com.drawingapp.services.DrawShape;
import com.drawingapp.services.DrawSquare;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class main {

    private static final String SQUARE_STRING = "SQUARE";

    private static void sendRequest(String requestType) {

        if (requestType.equals(SQUARE_STRING)) {
//            DrawShape d = new DrawSquare(); // Instead of explicitly creating it here. Ask guice to give the object
            Injector injector = Guice.createInjector(new AppModule()); //Initialize guice injector.. AppModule has the binding info for guice to resolve ambiguity
            DrawShape d = injector.getInstance(DrawShape.class); // Since DrawShape is bound to DrawSquare class in the AppModule, Guice creates a drawsquare object
//            SquareRequest sr = new SquareRequest(d); //Again use Guice for creating Request object
            SquareRequest sr = injector.getInstance(SquareRequest.class); //you can see here that you dont have to pass the square object previously created. that is because guice figure that out from the inject annotation in the request constructor
            sr.makeRequest();
            SquareRequest sr2 = injector.getInstance(SquareRequest.class); // create another request object

            //Once you make the DrawSquare class a singleton, below statement will evaluate to true
            // This is because we have a binding rule for DrawShape to give DrawSquare objects
            // Lets also add a rule to make drawsquare a singleton without making any changes to drawsquare class
            boolean isEqual = sr.getDrawShape() == sr2.getDrawShape();
            System.out.println("The drawshape objects are equal: " + isEqual);
        }
    }

    public static void main(String[] args) {
        System.out.println("App staring");
        sendRequest(SQUARE_STRING);
    }
}
