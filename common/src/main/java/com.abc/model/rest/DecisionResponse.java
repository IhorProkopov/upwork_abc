package com.abc.model.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

import static com.abc.model.rest.DecisionResponse.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class DecisionResponse {

    static final String TABLE_NAME = "decision_response";

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID id;
    @Column
    private Integer score;
    @Column(name = "emailage_response")
    private String emailAgeResponse;

    @Column(name = "zumigo_response")
    private String zumigoResponse;

    public DecisionResponse(Integer score, UUID id, String emailAgeResponse, String zumigoResponse) {
        this.id = id;
        this.score = score;
        this.emailAgeResponse = emailAgeResponse;
        this.zumigoResponse = zumigoResponse;
    }

    public DecisionResponse(Integer score, UUID id) {
        this.id = id;
        this.score = score;
    }

    public DecisionResponse() {
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

    public String getEmailAgeResponse() {
        return emailAgeResponse;
    }

    public void setEmailAgeResponse(String emailAgeResponse) {
        this.emailAgeResponse = emailAgeResponse;
    }

    public String getZumigoResponse() {
        return zumigoResponse;
    }

    public void setZumigoResponse(String zumigoResponse) {
        this.zumigoResponse = zumigoResponse;
    }
}
