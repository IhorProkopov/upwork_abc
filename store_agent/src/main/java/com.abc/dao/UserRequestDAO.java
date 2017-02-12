package com.abc.dao;

import com.abc.model.rest.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRequestDAO extends JpaRepository<UserRequest, UUID> {
}
