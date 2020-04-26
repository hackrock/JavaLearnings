package com.drawingapp;

import com.drawingapp.module.AppModule;
import com.drawingapp.requests.*;
import com.drawingapp.sample3partyLib.ColorCircle;
import com.drawingapp.services.DrawShape;
import com.drawingapp.services.DrawSquare;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.scene.Camera;

public class main {

    private static final String SQUARE_STRING = "SQUARE";
    private static final String CIRCLE_STRING = "CIRCLE";
    private static final String COLOR_SQUARE = "COLOR_SQUARE";
    private static final String COLOR_CIRCLE = "COLOR_CIRCLE";

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

    private static void sendRequest_2(String requestType) {
        //field injection
        if (requestType.equals(SQUARE_STRING)) {
            Injector injector = Guice.createInjector(new AppModule());
            SquareRequestFieldInjection request = injector.getInstance(SquareRequestFieldInjection.class);
            request.makeRequest();
        }

    }

    private static void sendRequest_3(String requestType) {
        //method injection
        if (requestType.equals(SQUARE_STRING)) {
            Injector injector = Guice.createInjector(new AppModule());
            SquareRequestMethodInjection request = injector.getInstance(SquareRequestMethodInjection.class);
            request.makeRequest();
        }
        else if (requestType.equals(CIRCLE_STRING)) {
            System.out.println("Got request for drawing circle!!");
            Injector injector = Guice.createInjector(new AppModule());

            CircleRequest request = injector.getInstance(CircleRequest.class);
            // Now if you dont tell guice to use DrawCircle object when CircleRequest is instantiated, then guice will
            // create DrawCircle for CircleRequest because that is what the binding rule.
            request.makeRequest();
        }
        else if (requestType.equals(COLOR_SQUARE)){
            System.out.println("Got request to color square");
            Injector injector = Guice.createInjector(new AppModule());
            ColorSquareRequest request = injector.getInstance(ColorSquareRequest.class);
            request.color();
        }
        else if (requestType.equals(COLOR_CIRCLE)){
            System.out.println("Got request to color circle");
            Injector injector = Guice.createInjector(new AppModule());
            ColorCircleRequest request = injector.getInstance(ColorCircleRequest.class);
            request.color();
        }

    }

    public static void main(String[] args) {
        System.out.println("App staring");
//        sendRequest(SQUARE_STRING);
//        sendRequest_2(SQUARE_STRING);
//        sendRequest_3(SQUARE_STRING);
//        sendRequest_3(CIRCLE_STRING);
        sendRequest_3(COLOR_CIRCLE);

    }
}
