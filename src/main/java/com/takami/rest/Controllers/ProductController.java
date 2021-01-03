package com.takami.rest.Controllers;

import com.takami.rest.Service.ProductService;
import com.takami.rest.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(ProductController.BASE_URL)
public class ProductController {

    public static final String BASE_URL = "/products";
    @Autowired
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


   @GetMapping
        public @ResponseBody ResponseEntity<List<Product>> getAllProducts()
   {

        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Product> getProductById(@PathVariable("id") Long id)
    {
        Product p = productService.findProductById(id);
        return new ResponseEntity<Product>(p, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public @ResponseBody ResponseEntity<?> deleteProduct(@PathVariable("id") Long id){
        productService.makeProductUnavailable(id);
        return new ResponseEntity<String>("Item with id "+id+" is unavailable",HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public @ResponseBody ResponseEntity<?> createNewProduct(@RequestBody Product product)
    {
        productService.addNewProduct(product);
        return new ResponseEntity<String>("Product is added", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public @ResponseBody ResponseEntity<?> makeProductAvailable(@PathVariable("id") Long id)
    {
        productService.makeProductAvailable(id);
        return new ResponseEntity<String>("Product with id" +id+" is available again!",HttpStatus.OK);
    }




    }







