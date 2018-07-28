package com.example.demo.parser.dto;

import com.example.demo.persistence.entity.UserBadgeEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserBadgeDto {
    private Long id;
    private BadgeDto badge;
    private LocalDateTime date;
    private Byte badgeClass;
    private Boolean tagBased;
    private UserDto user;

    public static UserBadgeEntity mapDtoToEntity(UserBadgeDto dto){
        if(dto == null){
            return null;
        }
        UserBadgeEntity entity = new UserBadgeEntity();
        entity.setId(dto.getId());
        entity.setBadge(BadgeDto.mapDtoToEntity(dto.getBadge()));
        entity.setTagBased(dto.getTagBased());
        entity.setBadgeClass(dto.getBadgeClass());
        entity.setDate(dto.getDate());
        entity.setUser(UserDto.mapDtoToEntity(dto.getUser()));
        return entity;
    }

    public static List<UserBadgeEntity> mapDtosToEntities(List<UserBadgeDto> dtos) {
        if(dtos == null){
            return null;
        }
        List<UserBadgeEntity> entities = new ArrayList<>();
        dtos.forEach(userBadgeDto -> {
            entities.add(mapDtoToEntity(userBadgeDto));
        });


        return entities;
    }

    public static UserBadgeDto mapEntityToDto(UserBadgeEntity entity){
        if(entity == null){
            return null;
        }
        UserBadgeDto dto = new UserBadgeDto();
        dto.setId(entity.getId());
        dto.setBadge(BadgeDto.mapEntityToDto(entity.getBadge()));
        dto.setTagBased(entity.getTagBased());
        dto.setBadgeClass(entity.getBadgeClass());
        dto.setDate(entity.getDate());
        dto.setUser(UserDto.mapEntityToDto(entity.getUser()));

        return dto;
    }

    public static List<UserBadgeDto> mapEntitiesToDtos(List<UserBadgeEntity> entities){
        if(entities == null){
            return null;
        }
        List<UserBadgeDto> dtos = new ArrayList<>();
        entities.forEach(userBadgeEntity -> {dtos.add(mapEntityToDto(userBadgeEntity));});
        return dtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BadgeDto getBadge() {
        return badge;
    }

    public void setBadge(BadgeDto badge) {
        this.badge = badge;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Byte getBadgeClass() {
        return badgeClass;
    }

    public void setBadgeClass(Byte badgeClass) {
        this.badgeClass = badgeClass;
    }

    public Boolean getTagBased() {
        return tagBased;
    }

    public void setTagBased(Boolean tagBased) {
        this.tagBased = tagBased;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
