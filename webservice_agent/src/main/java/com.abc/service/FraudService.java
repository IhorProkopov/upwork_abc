package com.abc.service;

import com.abc.model.rest.UserRequest;
import com.abc.model.rest.UserResponse;

public interface FraudService {

    UserResponse check(UserRequest request);

}
