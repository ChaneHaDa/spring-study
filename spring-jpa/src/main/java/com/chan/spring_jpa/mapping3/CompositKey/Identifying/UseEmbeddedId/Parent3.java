package com.chan.spring_jpa.mapping3.CompositKey.Identifying.UseEmbeddedId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// 복합키 식별 매핑 @EmbeddId 사용
@Entity
public class Parent3 {
    @Id
    private String id;
    private String name;

    public Parent3() {
    }

}