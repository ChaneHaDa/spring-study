package com.chan.springdatarest.Player;

import com.chan.springdatarest.Team.Team;
import jakarta.persistence.*;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private long number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Player() {
    }

    public Player(long id, String name, long number, Team team) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.team = team;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getNumber() {
        return number;
    }

    public Team getTeam() {
        return team;
    }

}
