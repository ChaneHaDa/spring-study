package com.chan.spring_jpa.mapping2.ManyToMany.TwoWay;

import java.io.Serializable;
import java.util.Objects;

public class MemberProductId implements Serializable {
    private String member;
    private String product;

    public MemberProductId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberProductId that = (MemberProductId) o;
        return Objects.equals(member, that.member) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, product);
    }
}
