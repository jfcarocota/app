package com.webapi.app;

import com.webapi.app.entities.User;

public interface IAuth {
    public boolean validate(User user);
}