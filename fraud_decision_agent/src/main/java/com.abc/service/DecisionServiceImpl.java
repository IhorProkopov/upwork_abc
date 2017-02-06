package com.abc.service;

import com.abc.dao.RulesDAO;
import com.abc.model.VendorResponse;
import com.abc.model.decision.Rule;
import com.abc.model.decision.RuleRequest;
import com.abc.model.rest.DecisionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DecisionServiceImpl implements DecisionService{

    @Autowired
    private RulesDAO rulesDao;

    @Override
    public DecisionResponse makeDecision(VendorResponse[] vendorResponses) {
        List<Rule> rules = rulesDao.getUsersRule(vendorResponses[0].getUserId());
        RuleRequest ruleRequest = new RuleRequest(vendorResponses);
        return makeDecision(ruleRequest, rules, vendorResponses[0].getUuid());
    }

    private DecisionResponse makeDecision(RuleRequest ruleRequest, List<Rule> rules, UUID uuid){
        Optional<Rule> rule = rules.stream().filter(r -> r.accept(ruleRequest)).findFirst();
        return rule.isPresent()? new DecisionResponse(rule.get().getScore(), uuid): new DecisionResponse(0, uuid);
    }

}

