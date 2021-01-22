package com.takami.rest.Requests;

import com.takami.rest.model.User;

public class RequestSignUp {

    private String username;
    private String password;
    private String firstName;
    private String familyName;
    private String address;
    private String email;


    public RequestSignUp(String username, String password, String firstName, String familyName, String address, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.familyName = familyName;
        this.address = address;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
