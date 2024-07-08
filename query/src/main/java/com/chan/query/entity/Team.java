package com.chan.query.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Member> members;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
