package com.chan.spring_jpa.mapping3.JoinTable.OneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

// OneToOne 조인 테이블
@Entity
public class Child5 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    // 양방향 필요시
    @OneToOne(mappedBy = "child")
    private Parent5 parent;
}
