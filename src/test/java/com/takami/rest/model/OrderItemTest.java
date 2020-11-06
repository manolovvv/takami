package com.takami.rest.model;

import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    @Test
    void setRequest() {
        Request request = new Request();
        request.setId(new Long(3));
        OrderItem orderItem = new OrderItem();
        orderItem.setRequest(request);
        assertEquals(orderItem.getRequest().getId(),3);
    }

    @Test
    void setId() {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(new Long(1));
        assertEquals(orderItem.getId(), new Long (1));

    }

    @Test
    void setProduct() {
        Product reel = new Reel();
        reel.setName("reel");
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(reel);
        assertEquals(orderItem.getProduct().getName(),"reel");
    }

    @Test
    void setQuantity() {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(3);
        assertEquals(orderItem.getQuantity(),3);
    }
}