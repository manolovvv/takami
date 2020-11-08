package com.takami.rest.Controllers;

import com.takami.rest.Service.CustomerService;
import com.takami.rest.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {
    public static final String BASE_URL = "/customers";
    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

   /* @GetMapping("/{username}/{password}")
    public Customer getOrderItems(@PathVariable("username") String username, @PathVariable("password") String password){
        return customerService.login(username,password);
    }*/

  //  @GetMapping("/{username}/{password}")
 //   public Customer login(@PathVariable("username") String username, @PathVariable("password") String password){
  //      return customerService.login(username, password);
  //  }


}
