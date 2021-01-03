package com.takami.rest.Requests;

public class RequestModifyUser {
    String address;
    String familyName;
    String firstName;
    String email;

    public RequestModifyUser(String address, String familyName, String firstName, String email) {
        this.address = address;
        this.familyName = familyName;
        this.firstName = firstName;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
