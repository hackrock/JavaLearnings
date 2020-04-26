package com.drawingapp.module;

import com.drawingapp.annotations.ColorValue;
import com.drawingapp.annotations.EdgeValue;
import com.drawingapp.requests.SquareRequest;
import com.drawingapp.requests.SquareRequestSubclass;
import com.drawingapp.services.DrawShape;
import com.drawingapp.services.DrawSquare;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        //when abstract class DrawShape  is requested then give the concrete class object of DrawSquare as per the binding rule below
        //All abstract class or interface must have a binding
        bind(DrawShape.class).to(DrawSquare.class).in(Scopes.SINGLETON); //Makes DrawSquare Singleton without any change in class
        // Now DrawSquare has 2 variables added which is initialized on construction. So for guice to instantiate the object it must pass some values to constructor
        //once way to do it as below. but this will make all Strings to Red and integer to 11.. Better way is to use annotations.
//        bind(Integer.class).toInstance(11);
//        bind(String.class).toInstance("Red");

        bind(Integer.class).annotatedWith(EdgeValue.class).toInstance(11); //Any integer annotated with EdgeValue will be injected with 11
        bind(String.class).annotatedWith(ColorValue.class).toInstance("RED");

        //when a concrete class is requested, if there is not binding rule, then guice instantiates the object
        // but if there a binding rule that bind the class to a subclass, then guice instantiates the subclass

        bind(SquareRequest.class).to(SquareRequestSubclass.class);


    }
}
