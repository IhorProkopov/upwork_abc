package com.abc.model;

import java.util.UUID;

public abstract class VendorRequest {

    private UUID uuid;
    private int userId;

    public VendorRequest(UUID uuid, int userId) {
        this.uuid = uuid;
        this.userId = userId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
