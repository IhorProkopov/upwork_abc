package com.abc.kafka;

import com.abc.model.VendorResponse;
import com.abc.model.rest.UserRequest;
import com.abc.service.VendorService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @Value("${store.vendor.response}")
    private String dbEndpoint;

    @Value("${decision.process}")
    private String decisionEndpoint;

    @Autowired
    private Gson gson;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private Sender sender;

    @KafkaListener(topics = "${vendor.interview}")
    public void receiveVendorRequest(String message) {
        System.out.println("receiveVendorRequest='" + message + "'");
        UserRequest request = gson.fromJson(message, UserRequest.class);
        String res = gson.toJson(vendorService.processRequest(request));
        sender.sendMessage(dbEndpoint, res);
        sender.sendMessage(decisionEndpoint, res);
    }

}