package com.takami.rest.Controllers;

import com.takami.rest.Service.RequestService;
import com.takami.rest.model.Customer;
import com.takami.rest.model.OrderItem;
import com.takami.rest.model.Request;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(RequestController.BASE_URL)
public class RequestController {
    public static final String BASE_URL = "/requests";

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/{id}")
    public String getRequest(@PathVariable("id") Long id) {
        try {
          return   requestService.getRequestById(id);
        } catch (Exception ex) {
            return ex.toString();
        }
    }
}
