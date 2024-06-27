package com.chan.spring_jpa.mapping3.JoinTable.ManyToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// ManyToMany 조인 테이블
@Entity
public class Child8 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Child8() {
    }
}
