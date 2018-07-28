package com.example.demo.parser.dto;

import com.example.demo.persistence.entity.VoteEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VoteDto {
    private Long id;
    private Long typeId;
    private Long userId;
    private LocalDateTime creationDate;
    private PostDto post;

    public static VoteEntity mapDtoToEntity(VoteDto dto){
        if(dto == null){
            return null;
        }
        VoteEntity entity = new VoteEntity();
        entity.setId(dto.getId());
        entity.setUserId(dto.getUserId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setPost(PostDto.mapDtoToEntity(dto.getPost()));
        entity.setTypeId(dto.getTypeId());

        return entity;
    }

    public static List<VoteEntity> mapDtosToEntities(List<VoteDto> dtos) {
        if (dtos == null) {
            return null;
        }
        List<VoteEntity> entities = new ArrayList<>();
        dtos.forEach(voteDto -> {
            entities.add(mapDtoToEntity(voteDto));
        });

        return entities;
    }

    public static VoteDto mapEntityToDto(VoteEntity entity){
        if(entity == null){
            return null;
        }
        VoteDto dto = new VoteDto();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setPost(PostDto.mapEntityToDto(entity.getPost()));
        dto.setTypeId(entity.getTypeId());

        return dto;
    }

    public static List<VoteDto> mapEntitiesToDtos(List<VoteEntity> entities){
        if(entities == null){
            return null;
        }
        List<VoteDto> dtos = new ArrayList<>();
        entities.forEach(voteEntity -> {dtos.add(mapEntityToDto(voteEntity));});
        return dtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public PostDto getPost() {
        return post;
    }

    public void setPost(PostDto post) {
        this.post = post;
    }
}
