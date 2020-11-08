package com.takami.rest.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HookTest {

    @Test
    void hookConstructor(){
        Hook h = new Hook(3,2,"hook","C//",12,20);
        assertEquals(h.getAmount(),3);
        assertEquals(h.getPrice(),2);
        assertEquals(h.getName(),"hook");
        assertEquals(h.getPathToImage(),"C//");
        assertEquals(h.getSize(),12);
        assertEquals(h.getPieces(),20);
    }

    @Test
    void setSize() {
        Hook h = new Hook();
        h.setSize(5);
        assertEquals(h.getSize(),5);
    }


    @Test
    void setPieces() {
        Hook h = new Hook();
        h.setPieces(20);
        assertEquals(h.getPieces(),20);
    }


}