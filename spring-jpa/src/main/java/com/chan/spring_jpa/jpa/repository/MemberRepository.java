package com.chan.spring_jpa.jpa.repository;

import com.chan.spring_jpa.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
