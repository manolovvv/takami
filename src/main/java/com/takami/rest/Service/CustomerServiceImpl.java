package com.takami.rest.Service;

import com.takami.rest.model.Customer;
import com.takami.rest.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public final CustomerRepository customerRepository;

   // @Override
    //public Customer login(String username, String password) {
   //     return null;
    //}



   /* @Override
    public Customer login(String username, String password) {

    }*/


}
