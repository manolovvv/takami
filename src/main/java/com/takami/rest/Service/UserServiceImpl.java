package com.takami.rest.Service;

import com.takami.rest.model.Customer;
import com.takami.rest.repositories.CustomerRepository;
import com.takami.rest.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;
    public final CustomerRepository customerRepository;

    public UserServiceImpl(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Long login(String username,String password) {
        Customer c =  customerRepository.getCustomerByUsernameAndPassword(username,password);
        return c.getId();
    }

    @Override
    public String register(Customer customer) {
        try {
            customerRepository.save(customer);
            return customerRepository.login(customer.getUsername(), customer.getPassword()).toString();
        }
        catch(Exception ex){
            return ex.toString();
        }
    }
}
