package com.chan.spring_jpa.mapping3.CompositKey.Identifying.UseEmbeddedId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

// 복합 키 식별 관계 매핑 EmbeddedId 사용
@Embeddable
public class Child3Id implements Serializable {
    private String parent3Id;
    @Column
    private String childId;

    public Child3Id() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child3Id child3Id = (Child3Id) o;
        return Objects.equals(parent3Id, child3Id.parent3Id) && Objects.equals(childId, child3Id.childId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent3Id, childId);
    }
}
