package com.chan.spring_jpa.mapping3.JoinTable.ManyToMany;

import jakarta.persistence.*;

import java.util.List;

// ManyToMany 조인 테이블
@Entity
public class Parent8 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "parent8_child8",
            joinColumns = @JoinColumn(name = "parent8_id"),
            inverseJoinColumns = @JoinColumn(name = "child8_id"))
    private List<Child8> child;
}
