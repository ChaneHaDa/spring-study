package com.chan.spring_jpa.mapping2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// 주 테이블 외래 키 일대일 단방향
@Entity
public class Locker4 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Locker4() {
    }
    public Locker4(String name) {
        this.name = name;
    }
}
