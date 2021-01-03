package com.takami.rest.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int amount;
    private double price;
    private String name;
    private String pathToImage;

    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private String description;


    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean available;





    public Product() {

    }



    public Product(Long id, int amount, double price, String name, String pathToImage, ProductType productType, String description) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.name = name;
        this.pathToImage = pathToImage;
        this.productType = productType;
        this.description = description;
    }

    public Product(Long id, int amount, double price, String name, String pathToImage, ProductType productType, String description, boolean available) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.name = name;
        this.pathToImage = pathToImage;
        this.productType = productType;
        this.description = description;
        this.available = available;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

