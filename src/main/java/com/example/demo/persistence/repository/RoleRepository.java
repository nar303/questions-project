package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    @Query("SELECT r From SystemUserEntity su LEFT JOIN su.roles r")
    List<RoleEntity> getRolesByUserName(String userName);
}
