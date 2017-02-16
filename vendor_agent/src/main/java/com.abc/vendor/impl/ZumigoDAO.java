package com.abc.vendor.impl;

import com.abc.model.VendorRequest;
import com.abc.model.VendorResponse;
import com.abc.model.vendor.ZumigoResponse;
import com.abc.model.zumigo.ZumigoRequest;
import com.abc.vendor.VendorDAO;
import org.springframework.stereotype.Repository;

import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;

@Repository("zumigo")
public class ZumigoDAO implements VendorDAO {

    private static final Random RAND = new Random();

    @Override
    public VendorResponse makeRequest(VendorRequest request) {
        ZumigoRequest zumigoRequest = (ZumigoRequest) request;
        ZumigoResponse.ConfidenceRatings ratings = new ZumigoResponse.ConfidenceRatings(newArrayList(String.valueOf(RAND.nextInt(101))),
                newArrayList(String.valueOf(RAND.nextInt(101))), newArrayList(String.valueOf(RAND.nextInt(101))));
        return new ZumigoResponse(request.getUuid(), request.getUserId(), true, ratings, null, null);
    }

}
