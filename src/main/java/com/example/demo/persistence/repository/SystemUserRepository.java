package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.SystemUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUserEntity,Long> {
    SystemUserEntity findByUserName(String userName);

//    @Query("SELECT su.roles FROM SystemUserEntity su WHERE su.userName = :userName")
//    public List<RoleEntity> getRolesByUserName(@Param("userName") String userName);

}
