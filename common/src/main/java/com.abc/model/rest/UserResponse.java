package com.abc.model.rest;

import java.util.UUID;

public abstract class UserResponse {

    private UUID id;

    public UserResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
