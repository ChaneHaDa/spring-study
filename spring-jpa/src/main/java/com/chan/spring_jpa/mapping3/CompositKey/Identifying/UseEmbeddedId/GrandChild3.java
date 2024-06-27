package com.chan.spring_jpa.mapping3.CompositKey.Identifying.UseEmbeddedId;

import jakarta.persistence.*;

// 복합 키 식별 관계 매핑 EmbeddedId 사용
@Entity
public class GrandChild3 {
    @EmbeddedId
    private GrandChild3Id id;
    @MapsId("child3Id")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "parent3_id"),
            @JoinColumn(name = "child3_id")
    })
    private Child3 child;
    private String name;

    public GrandChild3() {
    }
}
