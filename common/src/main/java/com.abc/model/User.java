package com.abc.model;

import com.abc.model.decision.Rule;

import javax.persistence.*;

@Entity(name = User.TABLE_NAME)
public class User {

    static final String TABLE_NAME ="users";

    @Id
//    @OneToMany(mappedBy = "user_id", targetEntity = Rule.class)
    private int id;
    @Column
    private String email;

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
}
