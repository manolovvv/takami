package com.takami.rest.Service;

import com.takami.rest.model.Product;
import com.takami.rest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;







    public List<Product> findAllProducts(){
       List<Product> allProducts= productRepository.findAll();
        return allProducts;

    }

    @Override
    public Product findProductById(Long id) {
        Product product  = productRepository.findById(id).get();
        return product;

    }

    @Override
    public void addNewProduct(Product product) {
        product.setAvailable(true);
        productRepository.save(product);
    }

    @Override
    public void makeProductUnavailable(Long id) {
        productRepository.makeItemUnavailable(id);
        //productRepository.deleteById(id);
    }

    @Override
    public void makeProductAvailable(Long id) {
        productRepository.makeItemAvailable(id);
        //productRepository.deleteById(id);
    }


}
