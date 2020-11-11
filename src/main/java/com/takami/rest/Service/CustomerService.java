package com.takami.rest.Service;

import com.takami.rest.model.Customer;
import com.takami.rest.model.Request;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerService {
    Long login(String username, String password);



    //Customer getCustomer(Long id);
    //Customer login(String username, String password);


}
