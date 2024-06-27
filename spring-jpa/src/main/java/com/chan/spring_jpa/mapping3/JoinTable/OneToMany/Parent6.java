package com.chan.spring_jpa.mapping3.JoinTable.OneToMany;

import jakarta.persistence.*;

import java.util.List;

// OneToMany 조인 테이블
@Entity
public class Parent6 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany
    @JoinTable(name = "parent6_child6",
            joinColumns = @JoinColumn(name = "parent6_id"),
            inverseJoinColumns = @JoinColumn(name = "child6_id"))
    private List<Child6> child;

    public Parent6() {
    }
}
