package com.chan.spring_jpa.mapping1.repository;

import com.chan.spring_jpa.mapping1.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
