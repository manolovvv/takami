package com.takami.rest.Controllers;


import com.takami.rest.Service.UserService;
import com.takami.rest.model.Customer;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public Long login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password){
        return userService.login(username,password);
    }

    @PostMapping("/register")
    public String register(@RequestBody Customer customer){
        return userService.register(customer);
    }

}
