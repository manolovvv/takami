package com.takami.rest.FakeData;

import com.takami.rest.model.Customer;
import com.takami.rest.model.Product;
import com.takami.rest.repositories.CustomerRepository;
import com.takami.rest.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FakeData implements CommandLineRunner {



    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    public FakeData(ProductRepository productRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;

    }

    @Override
    public void run(String... args) throws Exception{

        System.out.println("Products loading");

        Product p1 = new Product();
        p1.setName("rod");
        p1.setPrice(40);
        p1.setQuantity(16);
        productRepository.save(p1);

        Product p2 = new Product();
        p2.setName("line");
        p2.setPrice(3.79);
        p2.setQuantity(80);
        productRepository.save(p2);

        Product p3 = new Product();
        p3.setName("hook");
        p3.setPrice(1.67);
        p3.setQuantity(12);
        productRepository.save(p3);

        Customer c1 = new Customer();
        c1.setFirstName("Moni");
        c1.setFamilyName("Manolov");
        c1.setAddress("Eindhoven");
        c1.setUsername("manolov");
        c1.setPassword("manolov123");
        customerRepository.save(c1);

        Customer c2 = new Customer();
        c2.setFirstName("Gosho");
        c2.setFamilyName("Goshov");
        c2.setAddress("Tilburg");
        c2.setUsername("go6o");
        c2.setPassword("go60");
        customerRepository.save(c2);





        System.out.println("Products loaded succsesfully");
    }

}
