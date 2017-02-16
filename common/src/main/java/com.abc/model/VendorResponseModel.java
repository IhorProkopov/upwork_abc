package com.abc.model;

import com.abc.model.vendor.EmailAgeResponse;
import com.abc.model.vendor.ZumigoResponse;
import com.google.gson.Gson;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = VendorResponseModel.TABLE_NAME)
public class VendorResponseModel {

    private static final Gson GSON = new Gson();
    static final String TABLE_NAME = "vendor_response";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID uuid = UUID.randomUUID();
    @Column(name = "user_id")
    private int userId;
    @Column(name = "show_vendor_response")
    private boolean showVendorResponse;
    @Column(name = "data_json")
    private String dataJson;
    @Column
    private String vendor;
    @Column
    private OffsetDateTime time = OffsetDateTime.now();

    public VendorResponseModel(int id, UUID uuid, int userId, boolean showVendorResponse, String dataJson, String vendor) {
        this.id = id;
        this.uuid = uuid;
        this.userId = userId;
        this.showVendorResponse = showVendorResponse;
        this.dataJson = dataJson;
        this.vendor = vendor;
    }

    public VendorResponseModel() {
    }

    public VendorResponseModel(VendorResponse response) {
        this.uuid = response.getUuid();
        this.userId = response.getUserId();
        this.showVendorResponse = response.isShowVendorResponse();
        this.dataJson = GSON.toJson(response);
        if (response instanceof EmailAgeResponse){
            vendor = ServiceType.emailage.name();
        }
        if (response instanceof ZumigoResponse){
            vendor = ServiceType.zumigo.name();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDataJson() {
        return dataJson;
    }

    public void setDataJson(String dataJson) {
        this.dataJson = dataJson;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public OffsetDateTime getTime() {
        return time;
    }

    public void setTime(OffsetDateTime time) {
        this.time = time;
    }
}
