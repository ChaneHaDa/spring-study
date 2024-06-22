package com.chan.spring_jpa.mapping2.entity;

import jakarta.persistence.*;

// 주 테이블 외래 키 일대일 단방향
@Entity
public class Member4 {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    @OneToOne
    @JoinColumn(name = "LOCKER4_ID")
    private Locker4 locker;
}
