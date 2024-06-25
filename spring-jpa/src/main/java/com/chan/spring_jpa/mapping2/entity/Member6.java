package com.chan.spring_jpa.mapping2.entity;

import jakarta.persistence.*;

// 대상 테이블 외래 키 일대일 양방향
@Entity
public class Member6 {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    @OneToOne(mappedBy = "member")
    private Locker6 locker;

    public Member6() {
    }

    public Member6(String username) {
        this.username = username;
    }
}
