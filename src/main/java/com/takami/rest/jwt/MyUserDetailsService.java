package com.takami.rest.jwt;


import com.takami.rest.Service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService  {
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

     //   com.takami.rest.model.User u = userService.loadUserByUsername(username);

        return  new org.springframework.security.core.userdetails.User("foo","foo", new ArrayList<>());
    }
}
