package com.chan.spring_jpa.mapping3.JoinTable.ManyToOne;

import jakarta.persistence.*;

// ManyToOne 조인 테이블
@Entity
public class Child7 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne(optional = false)
    @JoinTable(name = "parent7_child7",
            joinColumns = @JoinColumn(name = "child7_id"),
            inverseJoinColumns = @JoinColumn(name = "parent7_id"))
    private Parent7 parent;
}
