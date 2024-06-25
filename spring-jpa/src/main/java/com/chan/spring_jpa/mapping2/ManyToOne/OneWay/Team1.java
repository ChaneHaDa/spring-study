package com.chan.spring_jpa.mapping2.ManyToOne.OneWay;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// 다대일 단방향
@Entity
public class Team1 {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Team1() {
    }

    public Team1(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
