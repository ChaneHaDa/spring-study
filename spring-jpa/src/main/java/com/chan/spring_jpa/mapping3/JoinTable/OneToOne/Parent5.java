package com.chan.spring_jpa.mapping3.JoinTable.OneToOne;

import jakarta.persistence.*;

// OneToOne 조인 테이블
@Entity
public class Parent5 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne
    @JoinTable(name = "parent5_locker5",
            joinColumns = @JoinColumn(name = "parent5_id"),
            inverseJoinColumns = @JoinColumn(name = "child5_id"))
    private Child5 child;

    public Parent5() {
    }
}
