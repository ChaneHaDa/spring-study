package com.chan.spring_jpa.mapping2.ManyToMany.TwoWay;

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

    public Order8() {
    }

    public Order8(Member8 member, Product8 product, int orderAmount) {
        this.member = member;
        this.product = product;
        this.orderAmount = orderAmount;
    }
}
