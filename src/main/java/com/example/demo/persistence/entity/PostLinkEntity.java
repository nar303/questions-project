package com.example.demo.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post_link")
public class PostLinkEntity {

    @Id
    private Long id;

    @Column
    private LocalDateTime creationDate;

    @Column
    private Long linkTypeId;

    @ManyToOne
    private PostEntity relatedPost;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public Long getLinkTypeId() {
        return linkTypeId;
    }

    public void setLinkTypeId(Long linkTypeId) {
        this.linkTypeId = linkTypeId;
    }

    public PostEntity getRelatedPost() {
        return relatedPost;
    }

    public void setRelatedPost(PostEntity relatedPost) {
        this.relatedPost = relatedPost;
    }
}
