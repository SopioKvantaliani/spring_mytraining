package com.cydeo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) // we define limits, we can put this annotation on top of methods.
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggingAnnotation {

    //@Target comes from java.lang package

}
