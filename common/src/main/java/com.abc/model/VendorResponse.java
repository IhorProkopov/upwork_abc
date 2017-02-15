package com.abc.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

public abstract class VendorResponse {

    static final String TABLE_NAME = "vendor_response";

    @Expose
    private int id;
    @Expose
    private UUID uuid = UUID.randomUUID();
    @Expose
    private int userId;
    @Expose
    private boolean showVendorResponse;

    public VendorResponse(UUID uuid, int userId, boolean showVendorResponse) {
        this.uuid = uuid;
        this.userId = userId;
        this.showVendorResponse = showVendorResponse;
    }

    public VendorResponse() {
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

    public boolean isShowVendorResponse() {
        return showVendorResponse;
    }

    public void setShowVendorResponse(boolean showVendorResponse) {
        this.showVendorResponse = showVendorResponse;
    }
}
