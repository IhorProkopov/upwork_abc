package com.abc.dao;

import com.abc.model.decision.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RulesDAO extends JpaRepository<Rule, Integer>{

        List<Rule> findByUserId(int user_id);

}
