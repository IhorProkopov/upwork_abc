package com.abc.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = VendorResponse.TABLE_NAME)
public abstract class VendorResponse {

    static final String TABLE_NAME = "vendor_response";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID uuid = UUID.randomUUID();
    @Column(name = "user_id")
    private int userId;
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
