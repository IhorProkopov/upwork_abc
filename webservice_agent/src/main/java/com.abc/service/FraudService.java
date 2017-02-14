package com.abc.service;

import com.abc.model.rest.DecisionResponse;
import com.abc.model.rest.UserRequest;

import java.util.UUID;

public interface FraudService {

    DecisionResponse check(UserRequest request);

}
