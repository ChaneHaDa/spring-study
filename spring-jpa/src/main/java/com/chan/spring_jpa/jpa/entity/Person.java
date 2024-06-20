package com.chan.spring_jpa.jpa.entity;

import com.chan.spring_jpa.constant.RoleType;
import jakarta.persistence.*;

@Entity
@Table(name = "PERSON", uniqueConstraints = {
        @UniqueConstraint(name = "NAME_AGE_UNIQUE", columnNames = {"NAME", "AGE"})
})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 10)
    private String name;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType role;
    @Transient
    private String firstName;
    @Transient
    private String lastName;

    @Access(AccessType.PROPERTY)
    public String getFullName() {
        return firstName + lastName;
    }

    public void setFullName(String fullName) {
        this.firstName = fullName.substring(0, fullName.indexOf(" "));
        this.lastName = fullName.substring(fullName.indexOf(" ") + 1);
    }

    public Person() {
    }

    public Person(Long id, String name, Integer age, RoleType role, String firstName, String lastName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
