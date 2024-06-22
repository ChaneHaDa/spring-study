package com.chan.spring_jpa.mapping2.entity;

import jakarta.persistence.*;

// 다대다 연결엔티티 활용
@Entity
@IdClass(MemberProductId.class)
public class MemberProduct8 {
    @Id
    @ManyToOne
    @JoinColumn(name = "MEMBER8_ID")
    private Member8 member;
    @Id
    @ManyToOne
    @JoinColumn(name = "Product8_ID")
    private Product8 product;
    private int orderAmount;
}
