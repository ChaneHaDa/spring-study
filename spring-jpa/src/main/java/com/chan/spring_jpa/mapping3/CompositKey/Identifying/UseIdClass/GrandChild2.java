package com.chan.spring_jpa.mapping3.CompositKey.Identifying.UseIdClass;

import jakarta.persistence.*;

// 복합 키 식별 관계 매핑 IdClass 사용
@Entity
@IdClass(GrandChild2Id.class)
public class GrandChild2 {

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "parent2_id"),
            @JoinColumn(name = "child2_id")
    })
    private Child2 child;

    @Id
    private String grandChildId;

    private String name;
}
