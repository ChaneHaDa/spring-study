package com.chan.spring_jpa.mapping2.OneToOne.OneWay;

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

    public Member4() {
    }

    public Member4(String username) {
        this.username = username;
    }
}
