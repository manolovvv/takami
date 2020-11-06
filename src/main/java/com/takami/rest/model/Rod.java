package com.takami.rest.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rod")
public class Rod extends Product{

    private int length;
    private int pieces;
    private double weight;

    public Rod(int amount, double price, String name, String pathToImage, int length, int pieces, double weight) {
        super(amount, price, name, pathToImage);
        this.length = length;
        this.pieces = pieces;
        this.weight = weight;
    }

    public Rod() {

    }


    public Long getId(){
       return super.getId();
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
