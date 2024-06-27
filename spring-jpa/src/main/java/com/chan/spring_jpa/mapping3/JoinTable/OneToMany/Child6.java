package com.chan.spring_jpa.mapping3.JoinTable.OneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// OneToMany 조인 테이블
@Entity
public class Child6 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Child6() {
    }

}
