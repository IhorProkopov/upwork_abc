package com.abc.service;

import com.abc.dao.RulesDAO;
import com.abc.model.VendorResponse;
import com.abc.model.decision.Rule;
import com.abc.model.decision.RuleRequest;
import com.abc.model.rest.DecisionResponse;
import com.abc.model.vendor.EmailAgeResponse;
import com.abc.model.vendor.ZumigoResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DecisionServiceImpl implements DecisionService {

    private static final Gson GSON = new Gson();

    @Autowired
    private RulesDAO rulesDao;

    @Override
    public DecisionResponse makeDecision(VendorResponse[] vendorResponses) {
        List<Rule> rules = rulesDao.findByUserId(vendorResponses[0].getUserId());
        RuleRequest ruleRequest = new RuleRequest(vendorResponses);
        DecisionResponse res = makeDecision(ruleRequest, rules, vendorResponses[0].getUuid());
        if (vendorResponses[0].isShowVendorResponse()) {
            Arrays.stream(vendorResponses).forEach(resp -> {
                if (resp instanceof EmailAgeResponse) {
                    res.setEmailAgeResponse(GSON.toJson(resp));
                }
                if (resp instanceof ZumigoResponse) {
                    res.setZumigoResponse(GSON.toJson(resp));
                }
            });
        }
        return res;
    }

    private DecisionResponse makeDecision(RuleRequest ruleRequest, List<Rule> rules, UUID uuid) {
        Optional<Rule> rule = rules.stream().filter(r -> r.accept(ruleRequest)).findFirst();
        return rule.isPresent() ? new DecisionResponse(rule.get().getScore(), uuid) : new DecisionResponse(0, uuid);
    }

}

