package com.abc.controller;

import com.abc.model.rest.DecisionResponse;
import com.abc.model.rest.UserRequest;
import com.abc.service.FraudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class FraudController {

    @Autowired
    private FraudService fraudService;

    @GetMapping("/check")
    public DecisionResponse check(@RequestParam("id")UUID id){
        return fraudService.getResult(id);
    }

    @PostMapping("/check")
    public DecisionResponse check(@RequestBody UserRequest request){
        return fraudService.check(request);
    }

}