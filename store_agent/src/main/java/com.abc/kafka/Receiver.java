package com.abc.kafka;

import com.abc.dao.ScoreDAO;
import com.abc.model.VendorResponse;
import com.abc.model.rest.DecisionResponse;
import com.abc.model.rest.UserRequest;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @Autowired
    private ScoreDAO scoreDAO;

    @Autowired
    private Gson gson;

    @KafkaListener(topics = "${store.user.request}")
    public void receiveRequest(String message) {
        System.out.println("receiveRequest: " + message);
        scoreDAO.saveUserRequest(gson.fromJson(message, UserRequest.class));
    }

    @KafkaListener(topics = "${store.vendor.response}")
    public void receiveVendorResponse(String message) {
        System.out.println("receiveVendorResponse: " + message);
        scoreDAO.storeVendorResponse(gson.fromJson(message, VendorResponse[].class));
    }

    @KafkaListener(topics = "${store.decision}")
    public void receiveDecision(String message) {
        System.out.println("receiveDecision: " + message);
        scoreDAO.storeDecision(gson.fromJson(message, DecisionResponse.class));
    }

}
