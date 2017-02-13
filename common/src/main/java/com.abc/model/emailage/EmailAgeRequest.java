package com.abc.model.emailage;

import com.abc.model.VendorRequest;
import com.abc.model.VendorResponse;

import java.util.UUID;

public class EmailAgeRequest extends VendorRequest{

    private String email;

    public EmailAgeRequest(String email, UUID uuid, int userId) {
        super(uuid, userId);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
