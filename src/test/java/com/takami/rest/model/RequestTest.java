package com.takami.rest.model;

import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RequestTest {
    @Test
    void RequestConstructor(){
        OrderItem orderItem = new OrderItem();
        orderItem.setId(new Long(1));
        Customer customer =  new Customer();
        customer.setId(new Long(2));
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        orderItemList.add(orderItem);
        Request request = new Request( customer,orderItemList);
        assertEquals(request.getCustomer().getId(), new Long(2));
       assertEquals(request.getOrderItem().get(0).getId(), new Long(1));
    }


    @Test
    void setId() {
        Request request = new Request();
        request.setId(new Long(1));
        assertEquals(request.getId(),new Long(1));

    }

    @Test
    void setCustomer() {
        Customer customer = new Customer() ;
        customer.setId(new Long(1));
        Request request = new Request();
        request.setCustomer(customer);
        assertEquals(request.getCustomer().getId(),new Long(1));

    }

    @Test
    void setOrderItem() {
    }
}