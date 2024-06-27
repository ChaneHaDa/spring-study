package com.chan.spring_jpa.mapping3.CompositKey.NonIdentifying.UseIdClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

// 복합키 비식별 매핑 IDCLASS 사용
@Entity
@IdClass(ParentId.class)
public class Parent {
    @Id
    private String id1;
    @Id
    private String id2;
    private String name;

    public Parent() {
    }
}
