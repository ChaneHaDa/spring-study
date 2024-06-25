package com.chan.spring_jpa.mapping3.Inheritance.NoTable;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

// MappedSuperclass의 사용
@Entity
//@AttributeOverride(name = "id", column = @Column(name = "member_id"))
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "member_name")),
        @AttributeOverride(name = "id", column = @Column(name = "member_id"))
})
public class EMember extends BaseEntity {
    private String email;
}
