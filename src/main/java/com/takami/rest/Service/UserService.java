package com.takami.rest.Service;

import com.takami.rest.model.Customer;

public interface UserService {
    public Long login(String username,String password);
    public String register(Customer customer);
}
