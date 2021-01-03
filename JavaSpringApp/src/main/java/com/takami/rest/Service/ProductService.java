package com.takami.rest.Service;

import com.takami.rest.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts() ;
    Product findProductById(Long id);
    void addNewProduct(Product product);
    void makeProductUnavailable(Long id);
    void makeProductAvailable(Long id);
   // Product returnProduct(Long id);
  //  Product addProduct(Product product);




}
