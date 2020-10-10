package com.takami.rest.Service;

import com.takami.rest.model.Customer;
import com.takami.rest.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public final CustomerRepository customerRepository;



    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
