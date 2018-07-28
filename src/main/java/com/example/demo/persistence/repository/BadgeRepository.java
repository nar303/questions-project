package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.BadgeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepository extends JpaRepository<BadgeEntity,Long> {
    BadgeEntity getByName(String name);
    boolean existsByName(String name);
}
