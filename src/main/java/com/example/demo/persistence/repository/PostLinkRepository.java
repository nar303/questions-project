package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.PostLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLinkRepository extends JpaRepository<PostLinkEntity,Long> {
}
