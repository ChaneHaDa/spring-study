package com.chan.spring_jpa.mapping1.repository;

import com.chan.spring_jpa.mapping1.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
