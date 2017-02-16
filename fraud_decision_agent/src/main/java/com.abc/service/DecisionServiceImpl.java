package com.abc.service;

import com.abc.dao.RulesDAO;
import com.abc.model.VendorResponse;
import com.abc.model.decision.Rule;
import com.abc.model.decision.RuleRequest;
import com.abc.model.emailage.EmailAgeRequest;
import com.abc.model.rest.DecisionResponse;
import com.abc.model.vendor.EmailAgeResponse;
import com.abc.model.vendor.ZumigoResponse;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DecisionServiceImpl implements DecisionService {

    private static final Gson GSON = new Gson();

    @Autowired
    private RulesDAO rulesDao;

    public static void main(String[] args) {
        List results = Lists.newArrayList(new EmailAgeResponse.Results("", null, null, null,
                null, null, null, null, "", null,
                String.valueOf(new Random().nextInt(1001)), null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null,
                null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null));

        EmailAgeResponse res =  (new EmailAgeResponse(UUID.randomUUID(), 0, new EmailAgeResponse.Query("", null, 0, null,
                null, null, results), (EmailAgeResponse.ResponseStatus) null));

        VendorResponse[] responses = new VendorResponse[]{res};
        DecisionServiceImpl target = new DecisionServiceImpl();
        RuleRequest ruleRequest = new RuleRequest(new VendorResponse[0]);
        List<Rule> rules = Lists.newArrayList(new Rule());
        rules.get(0).setZumigoLN(Lists.newArrayList(new Rule.MaxMin(79, 0)));
        rules.get(0).setZumigoFN(Lists.newArrayList(new Rule.MaxMin(79, 0)));
        rules.get(0).setZumigoAdress(Lists.newArrayList(new Rule.MaxMin(79, 0)));
        DecisionResponse response = target.makeDecision(ruleRequest, rules, UUID.randomUUID());
        System.out.println(response.getScore());
    }

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

