package com.abc.vendor.impl;

import com.abc.model.VendorRequest;
import com.abc.model.VendorResponse;
import com.abc.model.vendor.ConfidenceRatings;
import com.abc.model.vendor.CustomerDetails;
import com.abc.model.vendor.GetLineIdentityResponse;
import com.abc.model.vendor.ZumigoResponse;
import com.abc.model.zumigo.ZumigoRequest;
import com.abc.vendor.VendorDAO;
import com.google.common.collect.Lists;
import kotlin.collections.CollectionsKt;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static com.google.common.collect.Lists.newArrayList;

@Repository
public class ZumigoDAO implements VendorDAO {
    
    @Override
    public VendorResponse makeRequest(VendorRequest request) {
        ZumigoRequest zumigoRequest = (ZumigoRequest)request;    
        ConfidenceRatings ratings = new ConfidenceRatings(newArrayList("60"), newArrayList("50"), newArrayList("40"));
        Object nullObject = null;
        return new ZumigoResponse(true, ratings, (CustomerDetails)nullObject,
                (GetLineIdentityResponse)nullObject, request.getUuid(), request.getUserId());
    }
    
}
