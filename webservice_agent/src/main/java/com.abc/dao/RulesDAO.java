package com.abc.dao;

import com.abc.model.decision.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RulesDAO extends JpaRepository<Rule, Integer>{
}
