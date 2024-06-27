package com.chan.spring_jpa.mapping3.Inheritance;

import com.chan.spring_jpa.mapping3.Inheritance.Join.Item1;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// 상속관계 매핑 조인 전략
@Entity
@DiscriminatorValue("M")
public class Movie extends Item1 {
    private String director;
    private String actor;

    public Movie() {
    }
}
