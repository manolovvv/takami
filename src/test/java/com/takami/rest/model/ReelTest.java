package com.takami.rest.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReelTest {

    @Test
    void ReelConstructor(){
        Reel reel = new Reel(1,2,"reel","C//",3,4);
        assertEquals(reel.getAmount(),1);
        assertEquals(reel.getPrice(),2);
        assertEquals(reel.getName(),"reel");
        assertEquals(reel.getPathToImage(),"C//");
        assertEquals(reel.getDrag(),3);
        assertEquals(reel.getWeight(),4);
    }

    @Test
    void setDrag() {
        Reel reel = new Reel();
        reel.setDrag(30);
        assertEquals(reel.getDrag(),30);
    }

    @Test
    void setWeight() {
        Reel reel = new Reel();
        reel.setWeight(20);
        assertEquals(reel.getWeight(),20);
    }
}