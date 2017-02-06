package com.abc.kafka;

import com.abc.model.VendorResponse;
import com.abc.model.rest.DecisionResponse;
import com.abc.service.DecisionService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @Value("${webservice.decision}")
    private String webserviceTopic;

    @Value("${store.decision}")
    private String dbTopic;

    @Autowired
    private DecisionService decisionService;

    @Autowired
    private Sender sender;

    @Autowired
    private Gson gson;

    @KafkaListener(topics = "${decision.process}")
    public void receiveRequest(String message) {
        VendorResponse[] vendorResponses = gson.fromJson(message, VendorResponse[].class);
        DecisionResponse res = decisionService.makeDecision(vendorResponses);
        sender.sendMessage(webserviceTopic, gson.toJson(res));
        sender.sendMessage(dbTopic, gson.toJson(res));
    }

}
