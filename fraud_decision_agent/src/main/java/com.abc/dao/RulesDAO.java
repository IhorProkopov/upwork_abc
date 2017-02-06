package com.abc.dao;

import com.abc.model.decision.Rule;

import java.util.List;

public interface RulesDAO {

    List<Rule> getUsersRule(String userId);

}
