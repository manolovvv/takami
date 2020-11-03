package com.takami.rest.FakeData;

import com.takami.rest.model.Customer;
import com.takami.rest.model.Reel;
import com.takami.rest.model.Rod;
import com.takami.rest.repositories.CustomerRepository;
import com.takami.rest.repositories.ReelRepository;
import com.takami.rest.repositories.RodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FakeData implements CommandLineRunner {



    private final RodRepository rodRepository;
    private final ReelRepository reelRepository;
    private final CustomerRepository customerRepository;
    public FakeData(CustomerRepository customerRepository, RodRepository rodRepository, ReelRepository reelRepository) {
        this.rodRepository = rodRepository;
        this.customerRepository = customerRepository;

        this.reelRepository = reelRepository;
    }

    @Override
    public void run(String... args) throws Exception{

        System.out.println("Products loading");


        Rod rod = new Rod();
        rod.setAmount(3);
        rod.setName("rod");
        rod.setPathToImage("sadas");
        rod.setPrice(123);
        rodRepository.save(rod);

        Reel reel = new Reel();
        reel.setName("reel");
        reel.setAmount(12);
        reel.setPrice(13);
        reel.setWeight(135);
        reel.setDrag(31);
        reel.setPathToImage("dasdas");
        reelRepository.save(reel);

        Customer customer = new Customer();
        customer.setUsername("asd");
        customer.setPassword("asd");
        customerRepository.save(customer);

        System.out.println("Products loaded succsesfully");
    }

}
