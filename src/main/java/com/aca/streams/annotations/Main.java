package com.aca.streams.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@interface SimpleAnnotation {
    //primitive,String, Class, Enum
    String value() default "This is my simpleAnnotation ";
    int[] types() default {1,2,3};
}

@Target(ElementType.FIELD)
@interface Min{
    int minVal() default Integer.MIN_VALUE;
}

@SimpleAnnotation(value = "A class value")
class A{
    @Min(minVal = 5)
    private int a;
}

public class Main{
    public static void main(String[] args) {
        SimpleAnnotation description = A.class.getAnnotation(SimpleAnnotation.class);
        System.out.println(description.value());
    }
}


