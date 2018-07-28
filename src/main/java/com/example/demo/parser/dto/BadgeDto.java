package com.example.demo.parser.dto;

import com.example.demo.persistence.entity.BadgeEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BadgeDto {
    private Long id;
    private String name;

    public static BadgeEntity mapDtoToEntity(BadgeDto dto){
        if(dto == null){
            return null;
        }
        BadgeEntity entity = new BadgeEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public static List<BadgeEntity> mapDtosToEntities(List<BadgeDto> dtos) {
        if(dtos == null){
            return null;
        }
        List<BadgeEntity> entities = new ArrayList<>();
        dtos.forEach(badgeDto -> {entities.add(mapDtoToEntity(badgeDto));});

        return entities;
    }

    public static BadgeDto mapEntityToDto(BadgeEntity entity){
        if(entity == null){
            return null;
        }
        BadgeDto dto = new BadgeDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

    public static List<BadgeDto> mapEntitiesToDtos(List<BadgeEntity> entities){
        if(entities == null){
            return null;
        }
        List<BadgeDto> dtos = new ArrayList<>();
        entities.forEach(badgeEntity -> {dtos.add(mapEntityToDto(badgeEntity));});

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BadgeDto badgeDto = (BadgeDto) o;
        return Objects.equals(id, badgeDto.id) &&
                Objects.equals(name, badgeDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
