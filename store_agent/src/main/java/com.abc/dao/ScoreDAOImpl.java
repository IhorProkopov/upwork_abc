package com.abc.dao;

import com.abc.model.VendorResponse;
import com.abc.model.rest.DecisionResponse;
import com.abc.model.rest.UserRequest;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreDAOImpl implements ScoreDAO {

    public void saveUserRequest(UserRequest request) {
        System.out.println("saveUserRequest");
    }

    public void storeVendorResponse(VendorResponse[] vendorResponse) {
        System.out.println("storeVendorResponse");
    }

    public void storeDecision(DecisionResponse decision) {
        System.out.println("storeDecision");
    }
}
