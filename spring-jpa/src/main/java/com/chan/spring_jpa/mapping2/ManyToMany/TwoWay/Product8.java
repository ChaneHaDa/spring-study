package com.chan.spring_jpa.mapping2.ManyToMany.TwoWay;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// 다대다 연결엔티티 활용
@Entity
public class Product8 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Product8() {
    }

    public Product8(String name) {
        this.name = name;
    }
}
