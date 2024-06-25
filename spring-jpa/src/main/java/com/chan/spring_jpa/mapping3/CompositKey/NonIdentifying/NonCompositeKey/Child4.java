package com.chan.spring_jpa.mapping3.CompositKey.NonIdentifying.NonCompositeKey;

import jakarta.persistence.*;

// 비식별 관계로 구현
@Entity
public class Child4 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "parent4_id")
    private Parent4 parent;
}
