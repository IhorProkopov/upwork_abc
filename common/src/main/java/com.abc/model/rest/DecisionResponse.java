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
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class DecisionResponse{

    static final String TABLE_NAME = "decision_response";

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID id;
    @Column
    private Integer score;


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
}
