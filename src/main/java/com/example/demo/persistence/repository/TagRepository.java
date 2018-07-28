package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity,Long> {
    TagEntity findByName(String name);

    //@Query("SELECT t FROM TagEntity t WHERE t.name LIKE :query")
    TagEntity findByNameLike(String name);

    // List<TagEntity> getTagEntitiesByNameIsLike(String query);
}
