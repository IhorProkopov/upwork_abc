package com.abc.service;

import com.abc.model.VendorResponse;
import com.abc.model.rest.UserRequest;

public interface VendorService {

    VendorResponse[] processRequest(UserRequest request);

}
