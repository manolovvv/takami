package com.takami.rest.Service;

import com.takami.rest.model.Request;
import com.takami.rest.repositories.CustomerRepository;
import com.takami.rest.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    public CustomerServiceImpl(CustomerRepository customerRepository, RequestRepository requestRepository) {
        this.customerRepository = customerRepository;
        this.requestRepository = requestRepository;
    }

    @Autowired
    public final CustomerRepository customerRepository;

    @Autowired
    public final RequestRepository requestRepository;
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
