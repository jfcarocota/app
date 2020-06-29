package com.webapi.app.entities;

public class Login {

    String name;
    String profilePicture;
    int age;
    String role;

    public Login(String name, String profilePicture, int age, String role){
        this.name = name;
        this.profilePicture = profilePicture;
        this.age = age;
        this.role = role;
    }

    public String getName(){
        return name;
    }

    public String getProfilePicture(){
        return profilePicture;
    }

    public int getAge(){
        return age;
    }

    public String getRole(){
        return role;
    }
}