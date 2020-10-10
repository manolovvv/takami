package com.takami.rest.Service;

import com.takami.rest.model.Customer;

import java.util.List;

public interface CustomerService {
     Customer findCustomerById(Long id);
     List<Customer> findAllCustomers();

}
