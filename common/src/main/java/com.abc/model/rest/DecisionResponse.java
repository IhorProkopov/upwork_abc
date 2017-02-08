package com.abc.model.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;

@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class DecisionResponse{

    private Integer score;
    private UUID id;

    public DecisionResponse(Integer score, UUID id) {
        this.id = id;
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
