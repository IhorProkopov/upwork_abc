package com.abc.dao;

import com.abc.model.rest.DecisionResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DecisionDAO extends JpaRepository<DecisionResponse, UUID> {
}
