package com.abc.model;

import java.util.UUID;

public abstract class VendorRequest {

    private UUID uuid;
    private String userId;

    public VendorRequest(UUID uuid, String userId) {
        this.uuid = uuid;
        this.userId = userId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
