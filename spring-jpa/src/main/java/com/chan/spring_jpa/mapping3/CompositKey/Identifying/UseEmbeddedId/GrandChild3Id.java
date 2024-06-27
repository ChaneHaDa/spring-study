package com.chan.spring_jpa.mapping3.CompositKey.Identifying.UseEmbeddedId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

// 복합 키 식별 관계 매핑 EmbeddedId 사용
@Embeddable
public class GrandChild3Id implements Serializable {
    private Child3Id child3Id;
    @Column
    private String grandChildId;

    public GrandChild3Id() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrandChild3Id that = (GrandChild3Id) o;
        return Objects.equals(child3Id, that.child3Id) && Objects.equals(grandChildId, that.grandChildId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(child3Id, grandChildId);
    }
}
