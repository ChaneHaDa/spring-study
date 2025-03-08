package com.chan.springjpanm.repository;

import com.chan.springjpanm.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
