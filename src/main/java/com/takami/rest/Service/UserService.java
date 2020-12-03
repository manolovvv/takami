package com.takami.rest.Service;

import com.takami.rest.Exceptions.EmailExistException;
import com.takami.rest.model.User;

public interface UserService {
    //public String login(String username,String password);
    public String registerCustomer(User user) throws EmailExistException;
    public User loadUserByUsername(String username);
    public User getUserById(Long id);
}
