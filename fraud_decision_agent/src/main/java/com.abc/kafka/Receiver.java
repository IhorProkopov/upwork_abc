package com.abc.kafka;

import com.abc.model.VendorResponse;
import com.abc.model.rest.DecisionResponse;
import com.abc.service.DecisionService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

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
        log.info("Receive request='{}'", message);
        VendorResponse[] vendorResponses = gson.fromJson(message, VendorResponse[].class);
        DecisionResponse res = decisionService.makeDecision(vendorResponses);
        sender.sendMessage(webserviceTopic, gson.toJson(res));
        sender.sendMessage(dbTopic, gson.toJson(res));
    }

}
