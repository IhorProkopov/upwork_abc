package com.abc.controller;

import com.abc.model.User;
import com.abc.model.decision.Rule;
import com.abc.model.rest.DecisionResponse;
import com.abc.model.rest.RuleDTO;
import com.abc.model.rest.UserRequest;
import com.abc.service.DataService;
import com.abc.service.FraudService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@RestController
public class FraudController {

    @Autowired
    private FraudService fraudService;

    @Autowired
    private DataService dataService;

    @PostMapping("/check")
    public DecisionResponse check(@RequestBody UserRequest request) {
        return fraudService.check(request);
    }

    @PostMapping("/add_user")
    public void addUser(@RequestBody User user) {
        dataService.addUser(user);
    }

    @PostMapping("/add_rule")
    public void addRule(@RequestBody RuleDTO rule) {
        dataService.addRule(new Rule(rule));
    }

}





