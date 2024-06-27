package com.chan.spring_jpa.mapping3.JoinTable.ManyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

// ManyToOne 조인 테이블
@Entity
public class Parent7 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "parent")
    private List<Child7> child;

    public Parent7() {
    }
}
