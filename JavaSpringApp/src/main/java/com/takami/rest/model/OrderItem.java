package com.takami.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
            @JoinColumn(name = "request_id")
            @JsonIgnore
    Request request;

    @ManyToOne
    @JoinColumn(name = "product_id")

    Product product;

    int quantity;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;

    }

    public OrderItem() {

    }



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
