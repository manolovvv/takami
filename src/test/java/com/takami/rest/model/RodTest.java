package com.takami.rest.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RodTest {
    @Test
    void RodConstructor(){
        Rod rod = new Rod(3,2,"rod","C//",200,3,400);
        assertEquals(rod.getName(),"rod");
        assertEquals(rod.getAmount(),3);
        assertEquals(rod.getPrice(),2);
        assertEquals(rod.getPathToImage(),"C//");
        assertEquals(rod.getLength(),200);
        assertEquals(rod.getPieces(),3);
        assertEquals(rod.getWeight(),400);
    }


    @Test
    void setLength() {
        Rod rod = new Rod();
        rod.setLength(200);
        assertEquals(rod.getLength(),200);
    }

    @Test
    void setPieces() {
        Rod rod = new Rod();
        rod.setPieces(3);
        assertEquals(rod.getPieces(),3);
    }

    @Test
    void setWeight() {
        Rod rod = new Rod();
        rod.setWeight(300);
        assertEquals(rod.getWeight(),300);
    }
}