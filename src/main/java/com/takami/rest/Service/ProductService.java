package com.takami.rest.Service;

import com.takami.rest.model.Hook;
import com.takami.rest.model.Product;
import com.takami.rest.model.Reel;
import com.takami.rest.model.Rod;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAllProducts() ;
    Product findProductById(Long id);
    Reel addNewReel(Reel reel);
    Rod addNewRod(Rod rod);
    Hook addNewHook(Hook hook);
    boolean deleteProduct(Long id);
   // Product returnProduct(Long id);
  //  Product addProduct(Product product);




}
