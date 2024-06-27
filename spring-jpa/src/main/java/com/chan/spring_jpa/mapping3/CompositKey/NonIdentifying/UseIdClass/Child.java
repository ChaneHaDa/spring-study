package com.chan.spring_jpa.mapping3.CompositKey.NonIdentifying.UseIdClass;

import jakarta.persistence.*;

// 복합키 비식별 매핑 IDCLASS 사용
@Entity
public class Child {
    @Id
    private String id;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "parent_id1", referencedColumnName = "id1"),
            @JoinColumn(name = "parent_id2", referencedColumnName = "id2")
    })
    private Parent parent;

    public Child() {
    }
}
