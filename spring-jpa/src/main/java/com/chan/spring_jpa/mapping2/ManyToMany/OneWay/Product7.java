package com.chan.spring_jpa.mapping2.ManyToMany.OneWay;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// 다대다 단방향
@Entity
public class Product7 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Product7() {
    }

    public Product7(String name) {
        this.name = name;
    }
}
