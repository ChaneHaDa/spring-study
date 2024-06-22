package com.chan.spring_jpa.mapping2.entity;

import jakarta.persistence.*;

// 주 테이블 외래 키 일대일 양방향
@Entity
public class Member5 {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    @OneToOne
    @JoinColumn(name = "LOCKER5_ID")
    private Locker5 locker;
}
