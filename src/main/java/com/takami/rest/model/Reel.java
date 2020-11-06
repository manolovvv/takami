package com.takami.rest.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reel")
public class Reel extends Product{

    private int drag;
    private double weight;


    public Reel(int amount, double price, String name, String pathToImage, int drag, double weight) {
        super(amount, price, name, pathToImage);
        this.drag = drag;
        this.weight = weight;
    }

    public Reel() {

    }

    public int getDrag() {
        return drag;
    }

    public void setDrag(int drag) {
        this.drag = drag;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
