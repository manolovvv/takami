package com.takami.rest.Controllers;

import com.takami.rest.Service.CustomerService;
import com.takami.rest.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {
    public static final String BASE_URL = "/customers";
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public List<Customer> getAllCustomers(){
        return customerService.findAllCustomers();
    }


}
