package com.chan.spring_data_jpa.repository;

import com.chan.spring_data_jpa.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long>{
}
