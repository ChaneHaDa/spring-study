package com.chan.spring_jpa.mapping2.OneToOne.TwoWay;

import jakarta.persistence.*;

// 대상 테이블 외래 키 일대일 양방향
@Entity
public class Locker6 {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "MEMBER6_ID")
    private Member6 member;

    public Locker6() {
    }

    public Locker6(String name) {
        this.name = name;
    }
}
