package com.abc.service;

import com.abc.model.User;
import com.abc.model.decision.Rule;

public interface DataService {

    void addUser(User user);

    void addRule(Rule rule);

}
