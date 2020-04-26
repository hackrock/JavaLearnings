package com.drawingapp.module;

import com.drawingapp.annotations.*;
import com.drawingapp.providers.ColorCircleProvider;
import com.drawingapp.requests.CircleRequest;
import com.drawingapp.requests.SquareRequest;
import com.drawingapp.requests.SquareRequestSubclass;
import com.drawingapp.sample3partyLib.ColorShape;
import com.drawingapp.sample3partyLib.ColorSquare;
import com.drawingapp.services.DrawCircle;
import com.drawingapp.services.DrawShape;
import com.drawingapp.services.DrawSquare;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        //when abstract class DrawShape  is requested then give the concrete class object of DrawSquare as per the binding rule below
        //All abstract class or interface must have a binding
        // The below injection is called constructor injection
        // Some times an interface can have more than 1 concrete class eg: DrawShape implemented by DrawSquare and DrawCircle
        // In such cases guice must be be able to differentiate which concrete class to instantiate where. This is done by annotations.
        // 2 ways to creating annotation. One we have already seen. That is the recommended way. Another way to create named annotation which is not recommended because of absence of compile time checks
        bind(DrawShape.class).annotatedWith(Square.class).to(DrawSquare.class).in(Scopes.SINGLETON); //Makes DrawSquare Singleton without any change in class
        // Using out of the box annotation called named annotation below. It is not recommendation way since it provides no compile time check. SO if you have a type in "Circle" below then it is not caught
        bind(DrawShape.class).annotatedWith(Names.named("Circle")).to(DrawCircle.class);
        // Now DrawSquare has 2 variables added which is initialized on construction. So for guice to instantiate the object it must pass some values to constructor
        //once way to do it as below. but this will make all Strings to Red and integer to 11.. Better way is to use annotations.
//        bind(Integer.class).toInstance(11);
//        bind(String.class).toInstance("Red");

        bind(Integer.class).annotatedWith(EdgeValue.class).toInstance(11); //Any integer annotated with EdgeValue will be injected with 11
        bind(String.class).annotatedWith(ColorValue.class).toInstance("RED");

        //when a concrete class is requested, if there is not binding rule, then guice instantiates the object
        // but if there a binding rule that bind the class to a subclass, then guice instantiates the subclass

        bind(SquareRequest.class).to(SquareRequestSubclass.class);

//        bind(String.class).toInstance("RED"); //This is global so bad
        //lets annotate
        bind(String.class).annotatedWith(SquareColor.class).toInstance("JAMANTHY");


        //IF the Provides method below gets more complicated , you can move it to a Provider class as shown below
        bind(ColorShape.class).annotatedWith(Circle.class).toProvider(ColorCircleProvider.class).in(Scopes.SINGLETON);
        bind(String.class).annotatedWith(CircleColor.class).toInstance("Marroon");

    }

    @Provides
    @Singleton //make this singleton
    @Square // which implemation to use is specified by this annotation.
    ColorShape providesColorSquare(@SquareColor String color) {
        ColorSquare s = new ColorSquare(color);
        return s;
    }


}
