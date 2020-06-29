package com.webapi.app;

import com.webapi.app.entities.User;

public class Auth implements IAuth {

    public Auth(){}

    @Override
    public boolean validate(User user) {
        return user.getEmail().equals("admin") && user.getPassword().equals("admin");
    }
    
}