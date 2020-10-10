package com.takami.rest.Controllers;

import com.takami.rest.Service.ProductService;
import com.takami.rest.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(ProductController.BASE_URL)
public class ProductController {

    public static final String BASE_URL = "/products";
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    List<Product> getAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    Product getProductById(@PathVariable Long id){
        return productService.findProductById(id);
    }

    @PostMapping
    Long addNewProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }

}
