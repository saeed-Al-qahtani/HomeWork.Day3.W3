package com.example.day13injavacamp.Exersises.Controller.service;

import com.example.day13injavacamp.Exersises.Controller.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Userservice {
    private ArrayList<User> userList = new ArrayList<User>();

    public ArrayList<User> getUsers() {
        return userList;
    }

    public boolean addUser(User newUser) {
        return userList.add(newUser);
    }

    public User getUser(String userid) {
        for (User user : userList) {
            if (user.getId().equals(userid)) {
                return user;
            }
        }
        return null;
    }
}