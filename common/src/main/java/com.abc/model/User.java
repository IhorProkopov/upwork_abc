package com.abc.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity(name = User.TABLE_NAME)
public class User {

    static final String TABLE_NAME = "users";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(hidden = true)
    private int id;
    @Column
    private String email;
    @Column
    @ApiModelProperty(hidden = true)
    private OffsetDateTime time = OffsetDateTime.now();

    public User(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OffsetDateTime getTime() {
        return time;
    }

    public void setTime(OffsetDateTime time) {
        this.time = time;
    }
}
