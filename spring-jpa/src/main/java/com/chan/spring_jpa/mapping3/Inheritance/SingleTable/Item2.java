package com.chan.spring_jpa.mapping3.Inheritance.SingleTable;

import jakarta.persistence.*;

// 상속관계 매핑 단일 테이블 전략
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public class Item2 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;

    public Item2() {
    }
}
