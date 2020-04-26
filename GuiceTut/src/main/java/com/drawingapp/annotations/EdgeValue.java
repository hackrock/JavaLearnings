package com.drawingapp.annotations;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@BindingAnnotation //This tells guice that this annotation is a binding annotations and has to be used as such
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD}) //All annotations needs a target to which it can be applied
@Retention(RetentionPolicy.RUNTIME) // retention tells where the annotations are stored eg in code or runtime.. todo Readup on this
public @interface EdgeValue {
}
