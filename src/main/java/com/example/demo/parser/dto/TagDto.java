package com.example.demo.parser.dto;

import com.example.demo.persistence.entity.TagEntity;

import java.util.ArrayList;
import java.util.List;

public class TagDto {
    private Long id;
    private String name;
    private Long count;
    private Long excerptPostId;
    private Long wikiPostId;


    public static TagEntity mapDtoToEntity(TagDto dto){
        if(dto == null){
            return null;
        }
        TagEntity entity = new TagEntity();
        entity.setId(dto.getId());
        entity.setWikiPostId(dto.getWikiPostId());
        entity.setExcerptPostId(dto.getExcerptPostId());
        entity.setCount(dto.getCount());
        entity.setName(dto.getName());

        return entity;
    }

    public static List<TagEntity> mapDtosToEntities(List<TagDto> dtos){
        if(dtos == null){
            return null;
        }
        List<TagEntity> entities = new ArrayList<>();
        dtos.forEach(tagDto -> {entities.add(mapDtoToEntity(tagDto));});
        return entities;
    }

    public static TagDto mapEntityToDto(TagEntity entity){
        if(entity == null){
            return null;
        }
        TagDto dto = new TagDto();
        dto.setId(entity.getId());
        dto.setWikiPostId(entity.getWikiPostId());
        dto.setExcerptPostId(entity.getExcerptPostId());
        dto.setCount(entity.getCount());
        dto.setName(entity.getName());

        return dto;
    }

    public static List<TagDto> mapEntitiesToDtos(List<TagEntity> entities){
        if(entities == null){
            return null;
        }
        List<TagDto> dtos = new ArrayList<>();
        entities.forEach(tagEntity -> {dtos.add(mapEntityToDto(tagEntity));});
        return dtos;
    }

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
