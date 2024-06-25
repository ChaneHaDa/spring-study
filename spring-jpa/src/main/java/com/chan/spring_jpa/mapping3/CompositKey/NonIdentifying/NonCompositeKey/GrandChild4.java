package com.chan.spring_jpa.mapping3.CompositKey.NonIdentifying.NonCompositeKey;

import jakarta.persistence.*;

// 비식별 관계로 구현
@Entity
public class GrandChild4 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "child4_id")
    private Child4 child;
}
