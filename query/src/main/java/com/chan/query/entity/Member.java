package com.chan.query.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private int age;
    @ManyToOne
    private Team team;

    public Member() {
    }
}
