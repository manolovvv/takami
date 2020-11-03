package com.takami.rest.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Customer extends User {

    private String firstName;
    private String familyName;
    private String address;


    protected Customer(String username, String password, String firstName, String familyName, String address) {
        super(username, password);
        this.firstName = firstName;
        this.familyName = familyName;
        this.address = address;
    }

    public Customer() {
        super();
    }
}
