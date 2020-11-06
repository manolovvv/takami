package com.takami.rest.model;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testConstructor(){
        Customer c = new Customer("Moni123","Manolov123","Moni","Manolov");
        assertEquals(c.getFamilyName(),"Manolov");
        assertEquals(c.getFirstName(),"Moni");
        assertEquals(c.getUsername(),"Moni123");
        assertEquals(c.getPassword(),"Manolov123");
    }


    @Test
    void setRequests() {
        Customer c = new Customer();
        Request request1 = new Request();
        request1.setId(new Long(1));
        Request request2 = new Request();
        request2.setId(new Long(2));
        List<Request> requestList = new ArrayList<Request>();
        requestList.add(request1);
        requestList.add(request2);
        c.setRequests(requestList);
        assertEquals(c.getRequests(),requestList);
    }

    @Test
    void setFirstName() {
        Customer c = new Customer();
        c.setFirstName("Moni");
        assertEquals(c.getFirstName(),"Moni");
    }


    @Test
    void setFamilyName() {
        Customer c = new Customer();
        c.setFamilyName("Manolov");
        assertEquals(c.getFamilyName(),"Manolov");
    }
}