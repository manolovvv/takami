package com.takami.rest.Controllers;


import com.takami.rest.Exceptions.EmailExistException;
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

    @PostMapping("/login")
    public Long login(@RequestBody Customer customer){
        return userService.login(customer.getEmail(),customer.getPassword());
    }



    @PostMapping("/registerCustomer")
    public String register(@RequestBody Customer customer) throws EmailExistException {
        try{
        return userService.registerCustomer(customer);}
        catch (Exception ex){
            return ex.toString();
        }
    }

}
