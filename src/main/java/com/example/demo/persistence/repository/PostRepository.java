package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.PostEntity;
import com.example.demo.persistence.entity.TagEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
    boolean existsById(Long id);


    /*
    Where p.title LIKE %:query% OR " +
            "p.body LIKE %:query% OR p in (SELECT c.post FROM CommentEntity c WHERE c.text LIKE %:query%)" +
            " OR ( :tag IN (p.tags))
    * @Param("tag")  TagEntity tag
     *  @Param("query")String query,
     *  */

    @Query("SELECT p FROM PostEntity p Where p.title LIKE CONCAT('% ',:query,' %') AND " +
            "p.body LIKE CONCAT('% ',:query,' %') OR p IN (SELECT c.post FROM CommentEntity c WHERE c.text LIKE CONCAT('%',:query,'%') ) ORDER BY p.creationDate DESC") //  ORDER BY p.answerCount DESC
    List<PostEntity> getPostByQuery(@Param("query") String query, Pageable pageable);

    //-
    @Query("SELECT c.post FROM CommentEntity c WHERE c.text LIKE %:query%")
    List<PostEntity> getPostsFromComments(String query);

    //-
    @Query("SELECT p FROM PostEntity p WHERE :tag IN (p.tags)")
    List<PostEntity> getPostsByTag(TagEntity tag);

}
