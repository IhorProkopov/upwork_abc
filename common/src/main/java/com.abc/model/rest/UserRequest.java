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
    @Column(name = "user_id")
    private int userId;
    @Column(name = "show_vendor_response")
    private boolean showVendorResponse;

    public UserRequest(String email, String phoneNumber, List<ServiceType> serviceType, boolean async, int userId,
                       UUID uuid, boolean showVendorResponse) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.serviceType = serviceType;
        this.userId = userId;
        this.uuid = uuid;
        this.showVendorResponse = showVendorResponse;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public boolean isShowVendorResponse() {
        return showVendorResponse;
    }

    public void setShowVendorResponse(boolean showVendorResponse) {
        this.showVendorResponse = showVendorResponse;
    }
}
