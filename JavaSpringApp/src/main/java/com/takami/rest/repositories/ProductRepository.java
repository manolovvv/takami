package com.takami.rest.repositories;

import com.takami.rest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.available=0 WHERE p.id = ?1")
    void makeItemUnavailable(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.available=1 WHERE p.id = ?1")
    void makeItemAvailable(Long id);
}
