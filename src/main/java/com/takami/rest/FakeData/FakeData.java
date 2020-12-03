package com.takami.rest.FakeData;

import com.takami.rest.model.*;
import com.takami.rest.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class FakeData implements CommandLineRunner {


    PasswordEncoder passwordEncoder;

    @Autowired
    private final RodRepository rodRepository;

    @Autowired
    private final ReelRepository reelRepository;

   @Autowired
    private final OrderItemRepository orderItemRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final RequestRepository requestRepository;


    public FakeData(UserRepository userRepository, RodRepository rodRepository, ReelRepository reelRepository,/*, OrderItemRepository orderItemRepository*/OrderItemRepository orderItemRepository, RequestRepository requestRepository) {

        this.rodRepository = rodRepository;
        this.userRepository = userRepository;

        this.reelRepository = reelRepository;
       // this.orderItemRepository = orderItemRepository;
        this.orderItemRepository = orderItemRepository;
        this.requestRepository = requestRepository;
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
        reel.setAmount(3);
        reel.setDrag(30);
        reel.setWeight(550);
        reel.setPrice(40);
        reelRepository.save(reel);

        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(3);
        orderItem.setProduct(rodRepository.getOne( Long.valueOf(1)));
        orderItemRepository.save(orderItem);

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setQuantity(3);
        orderItem1.setProduct(reelRepository.getOne(Long.valueOf(2)));
        orderItemRepository.save(orderItem1);

        Request request = new Request();
        List<OrderItem> orderItemsRequest1 = new ArrayList<>();
        orderItemsRequest1.add(orderItem);
        orderItemsRequest1.add(orderItem1);
        request.setOrderItem(orderItemsRequest1);
        requestRepository.save(request);

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("$2a$10$h0P4yumzNORrna5C3uPh/u0bBabBgHK2CCYExqeK3yy6swwnN5nwW");
        admin.setRole(ERole.ROLE_ADMIN);
        userRepository.save(admin);


        User user = new User();
        user.setPassword("$2y$12$M4WhuhQfix4dHqJsiLg0eed5lkd/eHT.jVwsG06/xhNoSGM2LNeXW");
        user.setFamilyName("Manolov");
        user.setFirstName("Moni");
        user.setEmail("moni.manolov@abv.bg");
        user.setUsername("moni");
        user.setAddress("Eindhoven");
        user.setRole(ERole.ROLE_USER);
        List<Request> request1 = new ArrayList<>();
        user.setRequests(request1);
       userRepository.save(user);

        request.setUser(user);
        requestRepository.save(request);

        request1.add(request);
        user.setRequests(request1);
        userRepository.save(user);

        orderItem.setRequest(request);
        orderItem1.setRequest(request);
        orderItemRepository.save(orderItem);
        orderItemRepository.save(orderItem1);



        /*Reel reel = new Reel();
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

        Order order1 = new Order();
        order1.setCustomer(customer);

        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(3);
        orderItem.setOrder(order1);
        orderItem.setOrder(order1);
        orderItem.setProduct(reel);
        orderItemRepository.save(orderItem);


        Customer customer2 = new Customer();
        customer2.setUsername("dsa");
        customer2.setPassword("das");
        customerRepository.save(customer2);

        Order order2 = new Order();
        order2.setCustomer(customer2);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setQuantity(4);
        orderItem2.setProduct(rod);
        orderItem2.setOrder(order2);
        orderItemRepository.save(orderItem2);

        OrderItem orderItem3 = new OrderItem();
        orderItem3.setProduct(reel);
        orderItem3.setQuantity(5);
        orderItem3.setOrder(order1);
        orderItemRepository.save(orderItem3);*/

        System.out.println("Products loaded succsesfully");
    }

}
