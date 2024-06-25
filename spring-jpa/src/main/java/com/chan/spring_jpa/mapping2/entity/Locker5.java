package com.chan.spring_jpa.mapping2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

// 주 테이블 외래 키 일대일 양방향
@Entity
public class Locker5 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne(mappedBy = "locker")
    private Member5 member;

    public Locker5() {
    }
    public Locker5(String name) {
        this.name = name;
    }
}
