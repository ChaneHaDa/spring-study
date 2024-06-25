package com.chan.spring_jpa.mapping3.Inheritance;

import com.chan.spring_jpa.mapping3.Inheritance.Join.Item1;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

// 상속관계 매핑 조인 전략
@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "BOOK_ID")
public class Book extends Item1 {
    private String author;
    private String isbn;
}
