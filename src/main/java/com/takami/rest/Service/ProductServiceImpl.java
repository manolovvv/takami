package com.takami.rest.Service;

import com.takami.rest.model.Product;
import com.takami.rest.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final ProductRepository productRepository;


    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findAllProducts()
    {
        return productRepository.findAll();
    }

    @Override
    public Long addNewProduct(Product product) {
        productRepository.save(product);
        return product.getId();
    }
}
