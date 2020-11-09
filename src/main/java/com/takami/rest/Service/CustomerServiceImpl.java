package com.takami.rest.Service;

import com.takami.rest.model.Customer;
import com.takami.rest.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public final CustomerRepository customerRepository;

  /*  @Override
    public Customer getCustomer(Long id) {
         return customerRepository.getOne(id);
    }

*/
     @Override
    public Long login(String username, String password) {
       return customerRepository.login(username, password);
    }



   /* @Override
    public Customer login(String username, String password) {

    }*/


}
