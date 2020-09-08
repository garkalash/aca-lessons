package com.aca.patterns.behavioral.observer;

/**
 * @author: garik
 * @created" 9/8/2020, 10:09 PM
 */
public class Demo {
    public static void main(String[] args) {
        MyTopic topic = new MyTopic();

        Observer observer = new Subscriber("John");

        Observer observer1 = new Subscriber("Johnathan");

        Observer observer2 = new Subscriber("Santa");

        topic.register(observer);
        topic.register(observer1);
        topic.register(observer2);

        topic.setMessage("Hello all");
        topic.setMessage("Hello all1");

    }
}
