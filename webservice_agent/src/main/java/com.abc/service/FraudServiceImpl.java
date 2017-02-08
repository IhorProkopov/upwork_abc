package com.abc.service;

import com.abc.kafka.Receiver;
import com.abc.kafka.Sender;
import com.abc.model.rest.DecisionResponse;
import com.abc.model.rest.UserRequest;
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

    @Value("${await.timeout}")
    private long awaitTimeout;

    @Autowired
    private Gson gson;

    @Autowired
    private ConcurrentHashMap<UUID, DecisionResponse> decisionMap;

    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;

    @Override
    public DecisionResponse check(UserRequest request) {
        String jsonRequest = gson.toJson(request);
        sender.sendMessage(dbEndpoint, jsonRequest);
        sender.sendMessage(vendorTopic, jsonRequest);
        return request.isAsync() ? new DecisionResponse(null, request.getUuid()) : awaitResponse(request.getUuid());
    }

    @Override
    public DecisionResponse getResult(UUID id) {
        return awaitResponse(id);
    }

    private DecisionResponse awaitResponse(UUID uuid) {
        long ttl = System.currentTimeMillis() + awaitTimeout;
        while (System.currentTimeMillis() <= ttl) {
            if (decisionMap.containsKey(uuid)) {
                return decisionMap.remove(uuid);
            }
        }
        return new DecisionResponse(null, uuid);
    }

}
