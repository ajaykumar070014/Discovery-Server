package com.post.service.repository;

import com.post.service.entity.postModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<postModel,Long> {
}
