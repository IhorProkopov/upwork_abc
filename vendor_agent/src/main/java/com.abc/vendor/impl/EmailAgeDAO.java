package com.abc.vendor.impl;

import com.abc.model.VendorRequest;
import com.abc.model.VendorResponse;
import com.abc.model.emailage.EmailAgeRequest;
import com.abc.model.vendor.EmailAgeResponse;
import com.abc.vendor.VendorDAO;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository("emailage")
public class EmailAgeDAO implements VendorDAO {
    private static final String[] countries = new String[]{"US", "UK", "IND"};

    @Override
    public VendorResponse makeRequest(VendorRequest request) {
        int rand = (int) (Math.random() * countries.length);

        EmailAgeRequest emailAgeRequest = (EmailAgeRequest) request;
        List results = Lists.newArrayList(new EmailAgeResponse.Results(emailAgeRequest.getEmail(), null, null, null,
                null, null, null, null, countries[rand], null,
                String.valueOf(new Random().nextInt(1001)), null, null, null, null,
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

        return (new EmailAgeResponse(request.getUuid(), request.getUserId(), new EmailAgeResponse.Query(((EmailAgeRequest) request).getEmail(), null, 0, null,
                null, null, results), (EmailAgeResponse.ResponseStatus) null));
    }

}
