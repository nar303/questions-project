package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.UserBadgeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBadgeRepository extends JpaRepository<UserBadgeEntity,Long> {
}
