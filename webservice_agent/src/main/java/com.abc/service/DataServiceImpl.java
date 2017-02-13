package com.abc.service;

import com.abc.dao.RulesDAO;
import com.abc.dao.UserDAO;
import com.abc.model.User;
import com.abc.model.decision.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RulesDAO rulesDAO;

    @Override
    public void addUser(User user) {
        userDAO.save(user);
    }

    @Override
    public void addRule(Rule rule) {
        rulesDAO.save(rule);
    }
}
