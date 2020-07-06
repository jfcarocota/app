package com.webapi.app.entities;


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