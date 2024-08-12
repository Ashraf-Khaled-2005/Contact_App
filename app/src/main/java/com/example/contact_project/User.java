package com.example.contact_project;

public class User {
    private  int id;
    private  String name;
    private  String Number;


    public int getId() {
        return id;
    }

    public User(String name, String number) {
        this.name = name;
        Number = number;
    }

    public User(int id, String name, String number) {
        this.id = id;
        this.name = name;
        Number = number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

}
