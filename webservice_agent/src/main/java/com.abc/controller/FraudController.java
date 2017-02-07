package com.abc.controller;

import com.abc.model.rest.UserRequest;
import com.abc.model.rest.UserResponse;
import com.abc.service.FraudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FraudController {

    @Autowired
    private FraudService fraudService;

    @PostMapping("/check")
    public UserResponse check(@RequestBody UserRequest request){
        return fraudService.check(request);
    }

}