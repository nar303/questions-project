package com.example.demo.parser.dto;

import com.example.demo.persistence.entity.CommentEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommentDto {
    private Long id;
    private Long score;
    private String text;
    private LocalDateTime creationDate;
    private UserDto user;
    private PostDto post;

    public static CommentEntity mapDtoToEntity(CommentDto dto){
        if(dto == null){
            return null;
        }
        CommentEntity entity = new CommentEntity();
        entity.setId(dto.getId());
        entity.setText(dto.getText());
        entity.setScore(dto.getScore());
        entity.setCreationDate(dto.getCreationDate());
        // entity.setPost(PostDto.mapDtoToEntity(dto.getPost()));
        entity.setUser(UserDto.mapDtoToEntity(dto.getUser()));

        return entity;
    }

    public static List<CommentEntity> mapDtosToEntities(List<CommentDto> dtos) {
        if (dtos == null) {
            return null;
        }
        List<CommentEntity> entities = new ArrayList<>();

        dtos.forEach(commentDto -> {
            entities.add(mapDtoToEntity(commentDto));
        });

        return entities;
    }

    public static CommentDto mapEntityToDto(CommentEntity entity){
        if(entity == null){
            return null;
        }
        CommentDto dto = new CommentDto();
        dto.setId(entity.getId());
        dto.setText(entity.getText());
        dto.setScore(entity.getScore());
        dto.setCreationDate(entity.getCreationDate());
        dto.setPost(PostDto.mapEntityToDto(entity.getPost()));
        dto.setUser(UserDto.mapEntityToDto(entity.getUser()));

        return dto;
    }

    public static List<CommentDto> mapEntitiesToDtos(List<CommentEntity> entities){
        if(entities == null){
            return null;
        }
        List<CommentDto> dtos = new ArrayList<>();
        entities.forEach(commentEntity -> {dtos.add(mapEntityToDto(commentEntity));});
        return dtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public PostDto getPost() {
        return post;
    }

    public void setPost(PostDto post) {
        this.post = post;
    }
}
