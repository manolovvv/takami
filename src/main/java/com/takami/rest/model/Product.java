package com.takami.rest.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
protected Long id;

    protected int amount;
    protected double price;
protected String name;
protected String pathToImage;



    protected Product(int amount, double price, String name, String pathToImage) {

        this.amount = amount;
        this.price = price;
        this.name = name;
        this.pathToImage = pathToImage;
    }

    protected Product() {

    }


    public Long getId() {
        return id;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    public boolean buyProduct(int amount){
        if(this.amount - amount <0){
            return false;
        }
        else{
            this.amount = this.amount - amount;
            return true;
        }
    }
}

