package com.chan.spring_jpa.mapping3.CompositKey.Identifying.UseIdClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// 복합 키 식별 관계 매핑 IdClass 사용
@Entity
public class Parent2 {

    @Id
    private String id;
    private String name;
}
