package com.webapi.app.entities;

import ch.qos.logback.core.subst.Token;

public class ApiToken {
    String TOKEN;

    public ApiToken(String TOKEN){
        this.TOKEN = TOKEN;
    }

    public String getToken(){
        return TOKEN;
    }

    public void setToken(String TOKEN){
        this.TOKEN = TOKEN;
    }
}