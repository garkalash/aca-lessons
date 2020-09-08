package com.aca.patterns.behavioral.mediator;

/**
 * @author: garik
 * @created" 9/8/2020, 9:31 PM
 */
public class Demo {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediatorImpl();
        User user = new UserImpl("John", chatMediator);
        User user1 = new UserImpl("Johnathan", chatMediator);
        User user2 = new UserImpl("Santa", chatMediator);
        User user3 = new UserImpl("Poghos", chatMediator);
        User user4 = new UserImpl("John Junior", chatMediator);



        user.send("I am crossing the street");
    }
}
