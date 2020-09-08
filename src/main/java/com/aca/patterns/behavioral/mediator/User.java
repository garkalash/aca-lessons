package com.aca.patterns.behavioral.mediator;

import java.util.Objects;

/**
 * @author: garik
 * @created" 9/8/2020, 9:21 PM
 */
public abstract class User {
    protected final String name;
    protected final ChatMediator chatMediator;

    protected User(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
        chatMediator.addUser(this);
    }

    abstract void send(String msg);

    abstract void receive(String msg);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }
}

class UserImpl extends User {

    public UserImpl(String name, ChatMediator mediator){
        super(name, mediator);

    }

    @Override
    void send(String msg) {
        chatMediator.sendMessage(msg, this);
    }

    @Override
    void receive(String msg) {
        System.out.println("Received msg from mediator " + msg);
    }
}
