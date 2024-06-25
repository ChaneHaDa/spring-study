package com.chan.spring_jpa.mapping3.Inheritance.MultiTable;

import jakarta.persistence.*;

// 상속관계 매핑 구현 클래스마다 테이블 전략 매핑
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item3 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;
}
