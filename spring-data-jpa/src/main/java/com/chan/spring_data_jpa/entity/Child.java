package com.chan.spring_data_jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Child {
    @Id
    private Long id;

    private String name;

    public Child() {
    }

    public Child(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
