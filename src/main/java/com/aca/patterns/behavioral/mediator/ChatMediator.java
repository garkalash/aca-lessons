package com.aca.patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public interface ChatMediator {
    void sendMessage(String msg, User user);

    void addUser(User user);
}

class ChatMediatorImpl implements ChatMediator{

    private List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(String msg, User user) {
        for(User u : users){
            if(!u.equals(user)){
                u.receive(msg);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
