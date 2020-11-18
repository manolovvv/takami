package com.takami.rest.Service;


import com.takami.rest.model.Customer;
import com.takami.rest.model.OrderItem;
import com.takami.rest.model.Request;
import com.takami.rest.repositories.CustomerRepository;
import com.takami.rest.repositories.ProductRepository;
import com.takami.rest.repositories.RequestRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
   private final RequestRepository requestRepository;

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final ProductRepository productRepository;

    public RequestServiceImpl(RequestRepository requestRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.requestRepository = requestRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Request getRequestById(Long id) {

        try {
            Request request = new Request();
            Long newId  = requestRepository.getOne(id).getId();
            request.setId(newId);
            //Customer c = requestRepository.getOne(id).getCustomer();
          //  request.setCustomer(c);
            List<OrderItem> orderItems = requestRepository.getOne(id).getOrderItem();
            request.setOrderItem(orderItems);


            return request;


          //  return .toString();
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
    public List<Request> getAllRequestsByCustomerId(Long id) {
       // return requestRepository.readRequestsByCustomer_Id(id);
        return customerRepository.getOne(id).getRequests();
    }


}
