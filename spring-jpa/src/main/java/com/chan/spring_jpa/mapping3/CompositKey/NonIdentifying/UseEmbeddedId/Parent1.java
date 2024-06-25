package com.chan.spring_jpa.mapping3.CompositKey.NonIdentifying.UseEmbeddedId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

// 복합키 비식별 매핑 @EmbeddId 사용
@Entity
public class Parent1 {

    @EmbeddedId
    private ParentId1 id;
    private String name;
}
