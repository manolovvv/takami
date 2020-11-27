package com.takami.rest.repositories;


import com.takami.rest.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //@Query("SELECT Customer FROM Customer customer WHERE  customer.username = ?1 and customer.password = ?2")
    //Customer login(String username, String password);

}