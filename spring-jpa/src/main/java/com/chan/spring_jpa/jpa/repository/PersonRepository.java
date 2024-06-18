package com.chan.spring_jpa.jpa.repository;

import com.chan.spring_jpa.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
