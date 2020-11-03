package com.takami.rest.Controllers;

import com.takami.rest.Service.HookService;
import com.takami.rest.Service.ProductService;
import com.takami.rest.Service.ReelService;
import com.takami.rest.Service.RodService;
import com.takami.rest.model.Hook;
import com.takami.rest.model.Product;
import com.takami.rest.model.Reel;
import com.takami.rest.model.Rod;
import com.takami.rest.repositories.HookRepository;
import com.takami.rest.repositories.ReelRepository;
import com.takami.rest.repositories.RodRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(ProductController.BASE_URL)
public class ProductController {

    public static final String BASE_URL = "/products";
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
    @PostMapping("/addReel")
    public @ResponseBody ResponseEntity<Reel> addNewReel(@RequestBody Reel reel)
    {

       return new ResponseEntity<Reel>(productService.addNewReel(reel), HttpStatus.OK);

    }
    @PostMapping("/addRod")
    public @ResponseBody ResponseEntity<Rod> addNewRod(@RequestBody Rod rod)
    {

        return new ResponseEntity<Rod>(productService.addNewRod(rod), HttpStatus.OK);

    }

    @PostMapping("/addHook")
    public @ResponseBody ResponseEntity<Hook> addNewHook(@RequestBody Hook hook){
        return new ResponseEntity<Hook>(productService.addNewHook(hook),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody int deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return 1;
    }

    @GetMapping("/getRod")
    public Rod getRod(@RequestBody Product product){
        return (Rod)product;
    }



}
