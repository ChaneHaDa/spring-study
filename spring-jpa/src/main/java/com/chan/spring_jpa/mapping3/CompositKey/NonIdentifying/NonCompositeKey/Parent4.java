package com.chan.spring_jpa.mapping3.CompositKey.NonIdentifying.NonCompositeKey;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// 비식별 관계로 구현
@Entity
public class Parent4 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
