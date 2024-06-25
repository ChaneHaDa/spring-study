package com.chan.spring_jpa.mapping3.CompositKey.Identifying.UseEmbeddedId;

import jakarta.persistence.*;

// 복합 키 식별 관계 매핑 EmbeddedId 사용
@Entity
public class Child3 {
    @EmbeddedId
    private Child3Id id;
    @MapsId("parent3Id")
    @ManyToOne
    @JoinColumn(name = "parent3_id")
    private Parent3 parent;
    private String name;
}
