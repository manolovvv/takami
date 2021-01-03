package com.takami.rest.Service;

import com.takami.rest.Requests.RequestOrderItem;
import com.takami.rest.model.Request;

import java.util.List;

public interface RequestService {
    Request getRequestById(Long id);
    List<Request> getAllRequests();
    List<Request> getAllRequestsByUserId(Long id);

    String deleteRequestById(Long id);

    String createNewRequest(List<RequestOrderItem> request, Long id);
}
