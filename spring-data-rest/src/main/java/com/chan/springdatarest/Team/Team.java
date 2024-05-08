package com.chan.springdatarest.Team;

import com.chan.springdatarest.Player.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String city;
    private int championships;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Player> players;

    public Team() {
    }

    public Team(long id, String name, String city, int championships) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.championships = championships;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getChampionships() {
        return championships;
    }

    public List<Player> getPlayers() {
        return players;
    }

}
