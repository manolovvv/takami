package com.takami.rest.Controllers;

import com.takami.rest.Requests.RequestOrderItem;
import com.takami.rest.Service.RequestService;
import com.takami.rest.model.Request;
import com.takami.rest.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public  Request getRequest(@PathVariable("id") Long id) {

          return requestService.getRequestById(id);

    }

    @GetMapping
    public List<Request> getAllRequests(){
        return requestService.getAllRequests();
    }

    @GetMapping("/getaallbycustomerid/{id}")
    public List<Request> getRequestsByCustomerId(@PathVariable Long id){
        return requestService.getAllRequestsByUserId(id);
    }

    @GetMapping("/getUserFromRequestId/{id}")
    public User getUserFromRequestId(@PathVariable Long id){
        return requestService.getRequestById(id).getUser();
    }

    @DeleteMapping("/{id}")
    public String deleteRequest(@PathVariable Long id){
        return requestService.deleteRequestById(id);
    }

    @PostMapping("/newRequest/{id}")
    public String createRequest(@RequestBody List<RequestOrderItem> orderItems, @PathVariable Long id){

        return requestService.createNewRequest(orderItems,id);

    }

}
