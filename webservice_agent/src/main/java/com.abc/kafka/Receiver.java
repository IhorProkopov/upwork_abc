package com.abc.kafka;

import com.abc.model.rest.DecisionResponse;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Receiver {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Gson gson;

    @Autowired
    private ConcurrentHashMap<UUID, DecisionResponse> decisionMap;

    @KafkaListener(topics = "${webservice.decision}")
    public void receiveDecision(String message) {
        log.info("Receive decision='{}'", message);
        DecisionResponse decisionResponse = gson.fromJson(message, DecisionResponse.class);
        decisionMap.put(decisionResponse.getId(), decisionResponse);
    }

}