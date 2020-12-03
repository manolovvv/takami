package com.takami.rest.Controllers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.takami.rest.Service.ProductService;
import com.takami.rest.model.Hook;
import com.takami.rest.model.Product;
import com.takami.rest.model.Reel;
import com.takami.rest.model.Rod;
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

    /*@GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Product> getProductById(@PathVariable("id") Long id)
    {

        Product p = productService.findProductById(id);
        return new ResponseEntity<Product>(p, HttpStatus.OK);
    }*/
    @PostMapping("/addReel")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public @ResponseBody ResponseEntity<Reel> addNewReel(@RequestBody Reel reel)
    {

       return new ResponseEntity<Reel>(productService.addNewReel(reel), HttpStatus.OK);

    }
    @PostMapping("/addRod")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public @ResponseBody ResponseEntity<Rod> addNewRod(@RequestBody Rod rod)
    {

        return new ResponseEntity<Rod>(productService.addNewRod(rod), HttpStatus.OK);

    }

    @PostMapping("/addHook")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public @ResponseBody ResponseEntity<Hook> addNewHook(@RequestBody Hook hook){
        return new ResponseEntity<Hook>(productService.addNewHook(hook),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public @ResponseBody int deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return 1;
    }

    @GetMapping("/getRod")
    public Rod getRod(@RequestBody Product product){
        return (Rod)product;
    }

    /*@GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        Product p = productService.returnProduct(id);
        return new ResponseEntity<Product>(p, HttpStatus.OK);
    }*/

    /*@PostMapping("/addproduct")
    public Product addNewProduct(@RequestBody Object product) throws Exception{


            ObjectMapper mapper = new ObjectMapper();

            String p = mapper.writeValueAsString(product);
            Rod rod = mapper.reader().forType(Rod.class).readValue(p);
            return rod;


        }

     */


    }







