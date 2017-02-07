package com.abc.model.rest;

import java.util.UUID;

/**
 * Created by Ihor on 07.02.2017.
 */
public class DecisionResponse extends UserResponse{

    private int score;

    public DecisionResponse(int score, UUID id) {
        super(id);
        this.score = score;
    }
}
