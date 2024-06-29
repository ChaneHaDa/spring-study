package com.chan.spring_jpa.proxy.Loading;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// Lazy, Eager Loading
@Entity
public class LoTeam {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public LoTeam() {
    }
}
