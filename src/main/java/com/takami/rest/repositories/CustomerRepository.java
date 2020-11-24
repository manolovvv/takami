package com.takami.rest.repositories;


import com.takami.rest.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
  /*  @Query("SELECT customer.id FROM Customer customer WHERE  customer.username = ?1 and customer.password = ?2")
    Long login(String username, String password);
    Customer getCustomerByUsernameAndPassword(String username, String password);*/
    Boolean existsByUsername(String username);
    Customer getByUsername(String username);

}
