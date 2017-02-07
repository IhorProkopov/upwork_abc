package com.abc.model;

import java.util.UUID;

public class ErrorResponse {

    private String message;
    private int code;
    private UUID uuid;

    public ErrorResponse(String message, int code, UUID uuid) {
        this.message = message;
        this.code = code;
        this.uuid = uuid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
