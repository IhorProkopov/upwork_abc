package com.abc.vendor.impl;

import com.abc.model.VendorRequest;
import com.abc.model.VendorResponse;
import com.abc.model.vendor.ZumigoResponse;
import com.abc.model.zumigo.ZumigoRequest;
import com.abc.vendor.VendorDAO;
import org.springframework.stereotype.Repository;

import static com.google.common.collect.Lists.newArrayList;

@Repository("zumigo")
public class ZumigoDAO implements VendorDAO {

    @Override
    public VendorResponse makeRequest(VendorRequest request) {
        ZumigoRequest zumigoRequest = (ZumigoRequest) request;
        ZumigoResponse.ConfidenceRatings ratings = new ZumigoResponse.ConfidenceRatings(newArrayList("60"), newArrayList("50"), newArrayList("40"));
        return new ZumigoResponse(request.getUuid(), request.getUserId(), true, ratings, null, null);
    }

}
