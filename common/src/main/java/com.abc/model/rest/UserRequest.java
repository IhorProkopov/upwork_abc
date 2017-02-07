package com.abc.model.rest;

import com.abc.model.ServiceType;

import java.util.List;
import java.util.UUID;

public class UserRequest {

    private String email;
    private String phoneNumber;
    private List<ServiceType> serviceType;
    private boolean async;
    private String userId;
    private UUID uuid;

    public UserRequest(String email, String phoneNumber, List<ServiceType> serviceType, boolean async, String userId, UUID uuid) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.serviceType = serviceType;
        this.async = async;
        this.userId = userId;
        this.uuid = uuid;
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
