package com.chan.spring_jpa.mapping3.Inheritance.Join;

import jakarta.persistence.*;

// 상속관계 매핑 조인 전략
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item1 {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private int price;
}
