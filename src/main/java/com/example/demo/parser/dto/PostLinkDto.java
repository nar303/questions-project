package com.example.demo.parser.dto;

import com.example.demo.persistence.entity.PostLinkEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostLinkDto {
    private Long id;
    private LocalDateTime creationDate;
    private Long linkTypeId;
    private PostDto relatedPost;
    private PostDto post;

    public static PostLinkEntity mapDtoToEntity(PostLinkDto dto){
        if(dto == null){
            return null;
        }
        PostLinkEntity entity = new PostLinkEntity();
        entity.setId(dto.getId());
        entity.setRelatedPost(PostDto.mapDtoToEntity(dto.getRelatedPost()));
        entity.setLinkTypeId(dto.getLinkTypeId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setPost(PostDto.mapDtoToEntity(dto.getPost()));

        return entity;
    }

    public static List<PostLinkEntity> mapDtosToEntities(List<PostLinkDto> dtos) {
        if(dtos == null){
            return null;
        }
        List<PostLinkEntity> entities = new ArrayList<>();
        dtos.forEach(postLinkDto -> {
            entities.add(mapDtoToEntity(postLinkDto));
        });

        return entities;
    }

    public static PostLinkDto mapEntityToDto(PostLinkEntity entity){
        if(entity == null){
            return null;
        }
        PostLinkDto dto = new PostLinkDto();
        dto.setId(entity.getId());
        dto.setRelatedPost(PostDto.mapEntityToDto(entity.getRelatedPost()));
        dto.setLinkTypeId(entity.getLinkTypeId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setPost(PostDto.mapEntityToDto(entity.getPost()));

        return dto;
    }

    public static List<PostLinkDto> mapEntitiesToDtos(List<PostLinkEntity> entities){
        if(entities == null){
            return null;
        }
        List<PostLinkDto> dtos = new ArrayList<>();
        entities.forEach(postLinkEntity -> {dtos.add(mapEntityToDto(postLinkEntity));});
        return dtos;
    }

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

    public Long getLinkTypeId() {
        return linkTypeId;
    }

    public void setLinkTypeId(Long linkTypeId) {
        this.linkTypeId = linkTypeId;
    }

    public PostDto getRelatedPost() {
        return relatedPost;
    }

    public void setRelatedPost(PostDto relatedPost) {
        this.relatedPost = relatedPost;
    }

    public PostDto getPost() {
        return post;
    }

    public void setPost(PostDto post) {
        this.post = post;
    }
}
