package com.abc.service;

import com.abc.model.User;
import com.abc.model.decision.Rule;

import java.util.List;

public interface DataService {

    void addUser(User user);

    void addRule(Rule rule);

    List<Integer> getUsers();

}
