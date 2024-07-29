package com.chan.spring_data_jpa.repository;

import com.chan.spring_data_jpa.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}
