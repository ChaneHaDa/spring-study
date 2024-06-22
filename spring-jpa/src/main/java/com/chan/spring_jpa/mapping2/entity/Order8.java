package com.chan.spring_jpa.mapping2.entity;

import jakarta.persistence.*;

// 다대다 새로운 기본 키 사용
@Entity
public class Order8 {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "MEMBER8_ID")
    private Member8 member;
    @ManyToOne
    @JoinColumn(name = "PRODUCT8_ID")
    private Product8 product;
    private int orderAmount;
}
