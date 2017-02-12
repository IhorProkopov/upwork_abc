package com.abc.dao;

import com.abc.model.VendorResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorDAO extends JpaRepository<VendorResponse, Integer> {
}
