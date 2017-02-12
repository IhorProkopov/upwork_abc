package com.abc.model.rest;

import com.abc.model.ServiceType;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = UserRequest.TABLE_NAME)
public class UserRequest {

    static final String TABLE_NAME = "user_request";

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID uuid;
    @Column
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Transient
    private List<ServiceType> serviceType;
    @Column
    private boolean async;
    @Column(name = "user_id")
    private String userId;

    public UserRequest(String email, String phoneNumber, List<ServiceType> serviceType, boolean async, String userId, UUID uuid) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.serviceType = serviceType;
        this.async = async;
        this.userId = userId;
        this.uuid = uuid;
    }

    public UserRequest() {
        this.uuid = UUID.randomUUID();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<ServiceType> getServiceType() {
        return serviceType;
    }

    public void setServiceType(List<ServiceType> serviceType) {
        this.serviceType = serviceType;
    }

    public boolean isAsync() {
        return async;
    }

    public void setAsync(boolean async) {
        this.async = async;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
