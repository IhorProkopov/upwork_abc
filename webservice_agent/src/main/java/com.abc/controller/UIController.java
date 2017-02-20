package com.abc.controller;

import com.abc.model.decision.Rule;
import com.abc.service.DataService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UIController {

    private static final String USERS_KEY = "users";
    private static final String RULES_PAGE = "rules_page";
    private static final String REDIRECT_RULES_PAGE = "redirect:/rules";

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DataService dataService;

    @RequestMapping("/rules")
    ModelAndView index() {
        return new ModelAndView(RULES_PAGE, USERS_KEY, dataService.getUsers());
    }

    @PostMapping("/save_rule")
    public ModelAndView saveRule(@RequestParam("emailage_score") String emailageScore,
                                 @RequestParam("emailage_country_not_equals") String emailageCountryNotEquals,
                                 @RequestParam("emailage_country") String emailageCountry,
                                 @RequestParam("zumigo_fn") String zumigoFn,
                                 @RequestParam("zumigo_ln") String zumigoLn,
                                 @RequestParam("zumigo_address") String zumigoAddress,
                                 @RequestParam("user_id") Integer userId,
                                 @RequestParam("score") Integer score) {
        try {
            List<Rule.MaxMin> emailageScoreList = StringUtils.isNotBlank(emailageScore) ? parseMaxMin(emailageScore) : Collections.emptyList();
            List<Rule.MaxMin> zumigoFnList = StringUtils.isNotBlank(zumigoFn) ? parseMaxMin(zumigoFn) : Collections.emptyList();
            List<Rule.MaxMin> zumigoLnList = StringUtils.isNotBlank(zumigoLn) ? parseMaxMin(zumigoLn) : Collections.emptyList();
            List<Rule.MaxMin> zumigoAddressList = StringUtils.isNotBlank(zumigoAddress) ? parseMaxMin(zumigoAddress) : Collections.emptyList();
            List<String> country = StringUtils.isNotBlank(emailageCountry) ? parseCountry(emailageCountry) : Collections.emptyList();
            List<String> countryNotEquals = StringUtils.isNotBlank(emailageCountryNotEquals) ? parseCountry(emailageCountryNotEquals) : Collections.emptyList();
            dataService.addRule(new Rule(emailageScoreList, country, countryNotEquals, zumigoFnList, zumigoLnList, zumigoAddressList, score, userId));
        } catch (Throwable t) {
            log.warn("Cannot parse data", t);
        }
        return new ModelAndView(REDIRECT_RULES_PAGE, USERS_KEY, dataService.getUsers());
    }

    private List<String> parseCountry(String rawData) {
        return Lists.newArrayList(rawData.split(","));
    }

    private List<Rule.MaxMin> parseMaxMin(String rawData) {
        return Arrays.stream(rawData.split(";")).map(maxMin -> {
            String[] values = maxMin.split(":");
            return new Rule.MaxMin(Integer.parseInt(values[1]), Integer.parseInt(values[0]));
        }).collect(Collectors.toList());
    }

}
