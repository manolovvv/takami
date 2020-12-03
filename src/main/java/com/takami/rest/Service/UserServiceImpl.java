package com.takami.rest.Service;

import com.takami.rest.Exceptions.EmailExistException;
//import com.takami.rest.jwt.JwtUtil;
//import com.takami.rest.jwt.MyUserDetailsService;
import com.takami.rest.model.User;
import com.takami.rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;



    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //@Override
    //public String login(String username,String password) {
      //  User user =  userRepository.getUserByUsernameAndPassword(username,password);
      //  return user.getId();


    //}

    @Override
    public String registerCustomer(User user) throws EmailExistException {

            return null;





    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }


}
