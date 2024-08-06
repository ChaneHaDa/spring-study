package com.chan.spring_data_jpa.repository;

import com.chan.spring_data_jpa.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    @Query(value = "SELECT p FROM Parent p WHERE p.name = ?1")
    Parent findByName(String name);
}
