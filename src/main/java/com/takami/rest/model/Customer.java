package com.takami.rest.model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer extends User {

    private String firstName;
    private String familyName;


    @OneToMany
    @JoinTable(
            name="customer_request",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name= "request_id")
    )
    private List<Request> requests;

    public Customer(String username, String password,String email, String firstName, String familyName) {
        super(email,password,username);
        this.firstName = firstName;
        this.familyName = familyName;

    }

    public Customer(){

    }

    public Customer(String username,String password,String email){
        super(email,password,username);
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
