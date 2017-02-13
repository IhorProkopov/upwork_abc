package com.abc.model.zumigo;

import com.abc.model.VendorRequest;

import java.util.UUID;

/**
 * Created by Ihor on 07.02.2017.
 */
public class ZumigoRequest extends VendorRequest {

    private String requestData;

    public ZumigoRequest(UUID uuid, int userId, String requestData) {
        super(uuid, userId);
        this.requestData = requestData;
    }

}
