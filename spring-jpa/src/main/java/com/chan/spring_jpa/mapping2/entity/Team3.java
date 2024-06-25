package com.chan.spring_jpa.mapping2.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// 일대다 단방향
@Entity
public class Team3 {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "TEAM3_ID")
    private List<Member3> members = new ArrayList<>();

    public Team3() {
    }

    public Team3(String name) {
        this.name = name;
    }
}
