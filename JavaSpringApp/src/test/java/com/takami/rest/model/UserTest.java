package com.takami.rest.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class UserTest {


    @Test
    void testEmptyConstructor() {
        User user = new User();
        Assert.assertNotNull(user);
    }

    @Test
    void testConstructor() {
        User user = new User("moni","moni123",ERole.ROLE_USER.toString());
        Assert.assertNotNull(user);
    }

    @Test
    void testSetUsername(){
        User user = new User();
        user.setUsername("moni");
        Assert.assertEquals("moni",user.getUsername());
    }

    @Test
    void testSetPassword(){
        User user = new User();
        user.setPassword("moni123");
        Assert.assertEquals("moni123",user.getPassword());
    }

    @Test
    void testSetRole(){
        User user = new User();
        user.setRole(ERole.ROLE_USER);
        Assert.assertEquals(ERole.ROLE_USER,user.getRole());
    }

    @Test
    void testSetFirstName(){
        User user = new User();
        user.setFirstName("moni");
        Assert.assertEquals("moni",user.getFirstName());
    }

    @Test
    void testSetFamilyName(){
        User user = new User();
        user.setFamilyName("Manolov");
        Assert.assertEquals("Manolov",user.getFamilyName());
    }

    @Test
    void testSetEmail(){
        User user = new User();
        user.setEmail("moni@abv.bg");
        Assert.assertEquals("moni@abv.bg",user.getEmail());
    }

    @Test
    void testSetAddress(){
        User user = new User();
        user.setAddress("Tolstoy");
        Assert.assertEquals("Tolstoy",user.getAddress());
    }

}
