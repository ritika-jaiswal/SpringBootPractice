package com.jwt.authentication.services;

import com.jwt.authentication.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User> store = new ArrayList<>();

    public UserService() {
       store.add(new User(UUID.randomUUID().toString(),"Ritika Jaiswal", "rjaiswal123@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Mayuri Jaiswal", "mjaiswal123@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Muskan Jaiswal", "muskanjaiswal123@gmail.com"));

    }

    public List<User> getUsers(){
        return this.store;
    }
}

