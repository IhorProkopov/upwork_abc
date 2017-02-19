package com.abc.kafka;

import com.abc.dao.DecisionDAO;
import com.abc.dao.UserRequestDAO;
import com.abc.dao.VendorDAO;
import com.abc.model.VendorResponse;
import com.abc.model.VendorResponseModel;
import com.abc.model.rest.DecisionResponse;
import com.abc.model.rest.UserRequest;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

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
        log.info("Receive user request='{}'", message);
        userRequestDAO.save(gson.fromJson(message, UserRequest.class));
    }

    @KafkaListener(topics = "${store.vendor.response}")
    public void receiveVendorResponse(String message) {
        log.info("Receive vendor response='{}'", message);
        VendorResponse[] responses = gson.fromJson(message, VendorResponse[].class);
        for (VendorResponse response : responses) {
            vendorDAO.save(new VendorResponseModel(response));
        }
    }

    @KafkaListener(topics = "${store.decision}")
    public void receiveDecision(String message) {
        log.info("Receive decision='{}'", message);
        decisionDAO.save(gson.fromJson(message, DecisionResponse.class));
    }

}
