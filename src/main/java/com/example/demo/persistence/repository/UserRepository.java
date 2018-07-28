package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    boolean existsById(Long id);


    //@Modifying
    @Transactional
    @Query(value = "INSERT INTO user(id,about_me,account_id,creation_date,display_name,down_votes,last_access_date,location,profile_image_url,reputation,up_votes,views,website_url)" +
            " VALUES(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13)",nativeQuery = true)
    UserEntity insertWithNativeQuery(Long id, String about_me, Long account_id, LocalDateTime creation_date, String display_name, Long down_votes, LocalDateTime last_access_date, String location, String profile_image_url, Long reputation, Long up_votes, Long views, String website_url);

}
