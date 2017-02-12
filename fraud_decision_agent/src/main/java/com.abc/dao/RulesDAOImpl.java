package com.abc.dao;

import com.abc.model.decision.Rule;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Repository
public class RulesDAOImpl implements RulesDAO {

    @Override
    public List<Rule> getUsersRule(String userId) {
        return newArrayList(new Rule(newArrayList(new Rule.MaxMin(100, -100)), newArrayList(), newArrayList("UA", "PL"),
                newArrayList(new Rule.MaxMin(100, -100)), newArrayList(new Rule.MaxMin(100, -100)),
                newArrayList(new Rule.MaxMin(100, -100)), 100));
    }

}
