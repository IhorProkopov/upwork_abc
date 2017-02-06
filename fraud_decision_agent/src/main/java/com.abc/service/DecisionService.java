package com.abc.service;


import com.abc.model.VendorResponse;
import com.abc.model.rest.DecisionResponse;

public interface DecisionService {

    DecisionResponse makeDecision(VendorResponse[] vendorResponses);

}
