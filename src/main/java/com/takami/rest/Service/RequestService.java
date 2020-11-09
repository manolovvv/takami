package com.takami.rest.Service;

import com.takami.rest.model.Customer;
import com.takami.rest.model.OrderItem;
import com.takami.rest.model.Request;

import java.util.List;

public interface RequestService {
    Customer getRequestById(Long id);
}
