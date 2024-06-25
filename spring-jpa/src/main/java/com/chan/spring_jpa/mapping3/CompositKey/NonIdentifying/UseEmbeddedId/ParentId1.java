package com.chan.spring_jpa.mapping3.CompositKey.NonIdentifying.UseEmbeddedId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

// 복합키 비식별 매핑 @EmbeddId 사용
@Embeddable
public class ParentId1 implements Serializable {

    @Column
    private String id1;
    @Column
    private String id2;

    public ParentId1() {
    }

    public ParentId1(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentId1 parentId1 = (ParentId1) o;
        return Objects.equals(id1, parentId1.id1) && Objects.equals(id2, parentId1.id2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id1, id2);
    }

}
