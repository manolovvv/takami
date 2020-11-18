package com.takami.rest.Service;

import com.takami.rest.Exceptions.EmailExistException;
import com.takami.rest.model.Customer;
import com.takami.rest.model.User;
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
    public Long login(String email,String password) {
        User user =  userRepository.getUserByEmailAndPassword(email,password);
        return user.getId();
    }

    @Override
    public String registerCustomer(Customer customer) throws EmailExistException {

            if(userRepository.existsUserByEmail(customer.getEmail())){
                throw new EmailExistException("User with "+ customer.getEmail()+" already exists");
            }
            else{
                customerRepository.save(customer);
                return "Saved succsessfully";
            }





    }
}
