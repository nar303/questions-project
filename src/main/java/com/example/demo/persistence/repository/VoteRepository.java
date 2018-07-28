package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<VoteEntity,Long> {
}
