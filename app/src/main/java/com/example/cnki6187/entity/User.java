package com.example.cnki6187.entity;

/**
 * Created by cnki6187 on 2017/10/10.
 */

public class User {
    private String name;
    private int imageID;
    private int age;

    public User(String name,int age,int imageID)
    {
        this.name=name;
        this.age=age;
        this.imageID=imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
