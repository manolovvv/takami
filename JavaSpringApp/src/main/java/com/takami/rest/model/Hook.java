package com.takami.rest.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hook")
public class Hook extends Product {
    private int size;
    private int pieces;

    public Hook(int amount, double price, String name, String pathToImage, int size, int pieces) {
        super(amount, price, name, pathToImage);
        this.size = size;
        this.pieces = pieces;
    }

    public Hook(int size, int pieces) {
        this.size = size;
        this.pieces = pieces;
    }

    public Hook() {

    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }
}
