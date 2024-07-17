package com.chan.spring_data_jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Parent {
    @Id
    private Long id;
    private String name;

    public Parent() {
    }

    public Parent(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
