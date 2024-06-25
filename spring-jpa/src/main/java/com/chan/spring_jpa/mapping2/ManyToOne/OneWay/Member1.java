package com.chan.spring_jpa.mapping2.ManyToOne.OneWay;

import jakarta.persistence.*;

// 다대일 단방향
@Entity
public class Member1 {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    @ManyToOne
    @JoinColumn(name = "TEAM1_ID")
    private Team1 team;

    public Member1() {
    }

    public Member1(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team1 getTeam() {
        return team;
    }

    public void setTeam(Team1 team) {
        this.team = team;
    }
}
