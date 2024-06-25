package com.chan.spring_jpa.mapping2.ManyToOne.TwoWay;

import jakarta.persistence.*;

// 다대일 양방향
@Entity
public class Member2 {

    @Id @GeneratedValue
    private Long id;
    private String username;
    @ManyToOne
    @JoinColumn(name = "TEAM2_ID")
    private Team2 team;

    public Member2() {
    }

    public Member2(String username) {
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

    public Team2 getTeam() {
        return team;
    }

    //양방향 매핑시
    public void setTeam(Team2 team) {
        this.team = team;
        if(!team.getMembers().contains(this)){
            team.getMembers().add(this);
        }
    }
}
