package com.abc.dao;

import com.abc.model.decision.Rule;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Repository
public class RulesDAOImpl implements RulesDAO {

    @Override
    public List<Rule> getUsersRule(String userId) {
        return newArrayList(new Rule(newArrayList(new Rule.MaxMin(100, 0)), newArrayList("US"), newArrayList("UA"),
                newArrayList(new Rule.MaxMin(100, 0)), newArrayList(new Rule.MaxMin(100, 0)),
                newArrayList(new Rule.MaxMin(100, 0)), 100));
    }

}
