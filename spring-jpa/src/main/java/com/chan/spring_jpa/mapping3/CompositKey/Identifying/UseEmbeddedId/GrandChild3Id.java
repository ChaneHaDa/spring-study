package com.chan.spring_jpa.mapping3.CompositKey.Identifying.UseEmbeddedId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

// 복합 키 식별 관계 매핑 EmbeddedId 사용
@Embeddable
public class GrandChild3Id implements Serializable {
    private Child3Id child3Id;
    @Column
    private String grandChildId;
}
