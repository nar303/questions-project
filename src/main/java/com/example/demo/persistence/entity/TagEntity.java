package com.example.demo.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tag")
public class TagEntity {
    @Id
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private Long count;

    @Column
    private Long excerptPostId;

    @Column
    private Long wikiPostId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getExcerptPostId() {
        return excerptPostId;
    }

    public void setExcerptPostId(Long excerptPostId) {
        this.excerptPostId = excerptPostId;
    }

    public Long getWikiPostId() {
        return wikiPostId;
    }

    public void setWikiPostId(Long wikiPostId) {
        this.wikiPostId = wikiPostId;
    }
}
