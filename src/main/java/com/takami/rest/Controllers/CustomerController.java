package com.takami.rest.Controllers;

import com.takami.rest.Service.CustomerService;
import com.takami.rest.model.Customer;
import com.takami.rest.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {
    public static final String BASE_URL = "/customers";
    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/login")
    public Long getOrderItems(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password){
       Customer customer = new Customer();
       customer.setUsername(username);
       customer.setPassword(password);
      //  return c.getUsername();
       return customerService.login(customer.getUsername(),customer.getPassword());
    }







  //  @GetMapping("/{username}/{password}")
 //   public Customer login(@PathVariable("username") String username, @PathVariable("password") String password){
  //      return customerService.login(username, password);
  //  }


}
