package com.takami.rest.Service;


import com.takami.rest.Requests.RequestOrderItem;
import com.takami.rest.model.OrderItem;
import com.takami.rest.model.Request;
import com.takami.rest.model.User;
import com.takami.rest.repositories.OrderItemRepository;
import com.takami.rest.repositories.ProductRepository;
import com.takami.rest.repositories.RequestRepository;
import com.takami.rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
   private final RequestRepository requestRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final OrderItemRepository orderItemRepository;

    public RequestServiceImpl(RequestRepository requestRepository, UserRepository userRepository, ProductRepository productRepository, OrderItemRepository orderItemRepository) {
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public Request getRequestById(Long id) {

        try {
            Request request = /*new Request()*/ requestRepository.getOne(id);
           // Long newId  = requestRepository.getOne(id).getId();
           // request.setId(newId);
           // User u = requestRepository.getOne(id).getUser();
           //  request.setUser(u);
           //   List<OrderItem> orderItems = requestRepository.getOne(id).getOrderItem();
           //  request.setOrderItem(orderItems);

            return request;

        }
        catch (Exception ex){
            return null;
        }







    }

    @Override
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public List<Request> getAllRequestsByUserId(Long id) {

        return userRepository.getOne(id).getRequests();
    }

    @Override
    public String deleteRequestById(Long id) {
        Request request = requestRepository.getOne(id);
        User user = request.getUser();
        user.removeRequestById(id);
        userRepository.save(user);
        for(OrderItem orderItem: request.getOrderItem()){
            orderItemRepository.deleteById(orderItem.getId());
        }
//          request.setUser(null);
//          requestRepository.save(request);
//          requestRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public String createNewRequest(List<RequestOrderItem> orderItems, Long id) {
        Request newRequest = new Request();
        User user = userRepository.findById(id).get();
        user.addRequest(newRequest);
        newRequest.setUser(user);
        Request r = requestRepository.save(newRequest);
        List<OrderItem> newOrderItems = new ArrayList<>();
        for(RequestOrderItem RoR:orderItems){
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(productRepository.getOne(RoR.getProductId()));
            orderItem.setQuantity(RoR.getQuantity());
            orderItem.setRequest(requestRepository.getOne(r.getId()));
            orderItem.setTotalPrice(RoR.getQuantity()*productRepository.getOne(RoR.getProductId()).getPrice());
            newOrderItems.add(orderItem);
            orderItemRepository.save(orderItem);


        }
        newRequest.setOrderItem(newOrderItems);
        ;
        return "Created";

    }


}
