package com.takami.rest.Service;

import com.takami.rest.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    Product findProductById(Long id);
    List<Product> findAllProducts();
    Long addNewProduct(Product product);

}
