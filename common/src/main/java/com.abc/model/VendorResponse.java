package com.abc.model;

import java.util.UUID;

public abstract class VendorResponse {

    private UUID uuid = UUID.randomUUID();
    private String userId;

    public VendorResponse(UUID uuid, String userId) {
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
