package com.takami.rest.model;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer extends User {

    private String firstName;
    private String familyName;

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    @OneToMany
            (
                    mappedBy = "customer",
                    cascade = CascadeType.REMOVE,
                    orphanRemoval = true,
                    fetch = FetchType.EAGER
            )
    private List<Request> requests;


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



    public Customer(String username, String password, String firstName, String familyName) {
        super(username, password);
        this.firstName = firstName;
        this.familyName = familyName;

    }

    public Customer(){

    }


}
