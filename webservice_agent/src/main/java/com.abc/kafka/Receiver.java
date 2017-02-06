package com.abc.kafka;

import com.abc.model.rest.DecisionResponse;
import com.abc.model.rest.UserResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Receiver {

    @Autowired
    private Gson gson;

    @Autowired
    private ConcurrentHashMap<UUID, UserResponse> decisionMap;

    @KafkaListener(topics = "${webservice.decision}")
    public void receiveDecision(String message) {
        System.out.println("receiveDecision='" + message + "'");
        DecisionResponse decisionResponse = gson.fromJson(message, DecisionResponse.class);
        decisionMap.put(decisionResponse.getId(), decisionResponse);
    }

}