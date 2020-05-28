package com.chirag.firebasedemo;

public class User {
    String name;
    String gender;
    String email;
    int ph_number;

    public User(String name, String gender, String email, int ph_number) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.ph_number = ph_number;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPh_number() {
        return ph_number;
    }

    public void setPh_number(int ph_number) {
        this.ph_number = ph_number;
    }
}
