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
    private String userId;

    public VendorResponse(UUID uuid, String userId) {
        this.uuid = uuid;
        this.userId = userId;
    }

    public VendorResponse() {
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
