package com.abc.kafka;

import com.abc.dao.DecisionDAO;
import com.abc.dao.UserRequestDAO;
import com.abc.dao.VendorDAO;
import com.abc.model.VendorResponse;
import com.abc.model.rest.DecisionResponse;
import com.abc.model.rest.UserRequest;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @Autowired
    private UserRequestDAO userRequestDAO;

    @Autowired
    private DecisionDAO decisionDAO;

    @Autowired
    private VendorDAO vendorDAO;

    @Autowired
    private Gson gson;

    @KafkaListener(topics = "${store.user.request}")
    public void receiveRequest(String message) {
        System.out.println("receiveRequest: " + message);
        userRequestDAO.save(gson.fromJson(message, UserRequest.class));
    }

    @KafkaListener(topics = "${store.vendor.response}")
    public void receiveVendorResponse(String message) {
        System.out.println("receiveVendorResponse: " + message);
        vendorDAO.save(Lists.newArrayList(gson.fromJson(message, VendorResponse[].class)));
    }

    @KafkaListener(topics = "${store.decision}")
    public void receiveDecision(String message) {
        System.out.println("receiveDecision: " + message);
        decisionDAO.save(gson.fromJson(message, DecisionResponse.class));
    }

}
