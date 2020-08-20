package com.aca.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: garik
 * @created" 7/28/2020, 8:36 PM
 */
public class Main {
    public static void main(String[] args) {
        try {
            TestClass testClassObj = new TestClass();

            @SuppressWarnings("unchecked")
            Class<TestClass> testClass = (Class<TestClass>) Class.forName("com.aca.reflection.TestClass");

            /*testClass.getDeclaredMethods();
            testClass.getDeclaredFields();
            testClass.getConstructors();*/

            for(Method method: testClass.getDeclaredMethods()){
                try {
                    method.setAccessible(true);
                    method.invoke(testClassObj, "Private method hello");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
