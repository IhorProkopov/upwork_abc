package com.abc.vendor.impl;

import com.abc.model.VendorRequest;
import com.abc.model.VendorResponse;
import com.abc.model.emailage.EmailAgeRequest;
import com.abc.model.vendor.EmailAgeResponse;
import com.abc.model.vendor.Query;
import com.abc.model.vendor.ResponseStatus;
import com.abc.model.vendor.Results;
import com.abc.vendor.VendorDAO;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class EmailAgeDAO implements VendorDAO {

    @Override
    public VendorResponse makeRequest(VendorRequest request) {
        EmailAgeRequest emailAgeRequest = (EmailAgeRequest) request;
        List results = Lists.newArrayList(new Results(emailAgeRequest.getEmail(), null, null, null,
                null, null, null, null, null, null,
                String.valueOf((new Random()).nextInt()), null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null,
                null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null));
        return (new EmailAgeResponse(new Query(((EmailAgeRequest) request).getEmail(), null, 0, null,
                null, null, results), (ResponseStatus) null, request.getUuid(), request.getUserId()));
    }

}
