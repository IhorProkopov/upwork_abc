package com.abc.dao;

import com.abc.model.VendorResponse;
import com.abc.model.rest.DecisionResponse;
import com.abc.model.rest.UserRequest;

public interface ScoreDAO {

    void saveUserRequest(UserRequest request);

    void storeVendorResponse(VendorResponse[] vendorResponse);

    void storeDecision(DecisionResponse decision);

}