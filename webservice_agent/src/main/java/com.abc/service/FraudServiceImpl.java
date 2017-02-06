package com.abc.service;

import com.abc.kafka.Receiver;
import com.abc.kafka.Sender;
import com.abc.model.rest.DecisionResponse;
import com.abc.model.rest.IdResponse;
import com.abc.model.rest.UserRequest;
import com.abc.model.rest.UserResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FraudServiceImpl implements FraudService {

    @Value("${store.user.request}")
    private String dbEndpoint;

    @Value("${vendor.interview}")
    private String vendorTopic;

    @Autowired
    private Gson gson;

    @Autowired
    private ConcurrentHashMap<UUID, UserResponse> decisionMap;

    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;

    @Override
    public UserResponse check(UserRequest request) {
        String jsonRequest = gson.toJson(request);
        sender.sendMessage(dbEndpoint, jsonRequest);
        sender.sendMessage(vendorTopic, jsonRequest);
        return request.getAsync() ? new IdResponse(request.getUuid()) : awaitResponse(request.getUuid());
    }

    private DecisionResponse awaitResponse(UUID uuid) {
        while (true) {
            if (decisionMap.containsKey(uuid)) {
                return (DecisionResponse) decisionMap.get(uuid);
            }
        }
    }

}
