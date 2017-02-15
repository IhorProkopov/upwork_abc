package com.abc.dao;

import com.abc.model.VendorResponse;
import com.abc.model.VendorResponseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorDAO extends JpaRepository<VendorResponseModel, Integer> {
}
