package com.takami.rest.Service;

import com.takami.rest.model.Customer;
import com.takami.rest.model.OrderItem;
import com.takami.rest.model.Request;
import com.takami.rest.repositories.ProductRepository;
import com.takami.rest.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
   private final RequestRepository requestRepository;

    @Autowired
    private final ProductRepository productRepository;

    public RequestServiceImpl(RequestRepository requestRepository, ProductRepository productRepository) {
        this.requestRepository = requestRepository;
        this.productRepository = productRepository;
    }

    @Override
    public String getRequestById(Long id) {
    try {
        return requestRepository.getOne(id).toString();
    }
    catch (Exception ex ){
        return ex.toString();
    }

    }
}
