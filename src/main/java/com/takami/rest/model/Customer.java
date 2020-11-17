package com.takami.rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Customer extends User {

    private String firstName;
    private String familyName;


    @OneToMany
            (
                    mappedBy = "customer",
                    cascade = CascadeType.REMOVE,
                    orphanRemoval = true,
                    fetch = FetchType.EAGER
            )
    @JsonIgnoreProperties("requests")
    private List<Request> requests;

    public Customer(String username, String password, String firstName, String familyName) {
        super(username, password);
        this.firstName = firstName;
        this.familyName = familyName;

    }

    public Customer(){

    }

    public Customer(String username,String password){
        super(username,password);
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

   public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }





}
