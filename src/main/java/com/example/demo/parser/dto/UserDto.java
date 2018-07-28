package com.example.demo.parser.dto;

import com.example.demo.persistence.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private Long id;
    private Long reputation;
    private LocalDateTime creationDate;
    private String displayName;
    private LocalDateTime lastAccessDate;
    private String location;
    private String aboutMe;
    private Long views;
    private Long upVotes;
    private Long downVotes;
    private Long accountId;
    private String profileImageUrl;
    private String websiteUrl;
    private List<UserBadgeDto> badges;

    public static UserEntity mapDtoToEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }
        UserEntity entity = new UserEntity();

        entity.setId(dto.getId());
        entity.setAccountId(dto.getAccountId());
        // entity.setBadges(UserBadgeDto.mapDtosToEntities(dto.getBadges()));
        entity.setDownVotes(dto.getDownVotes());
        entity.setDisplayName(dto.getDisplayName());
        entity.setUpVotes(dto.getUpVotes());
        entity.setWebsiteUrl(dto.getWebsiteUrl());
        entity.setProfileImageUrl(dto.getProfileImageUrl());
        entity.setViews(dto.getViews());
        entity.setAboutMe(dto.getAboutMe());
        entity.setLocation(dto.getLocation());
        entity.setReputation(dto.getReputation());
        entity.setCreationDate(dto.getCreationDate());
        entity.setLastAccessDate(dto.getLastAccessDate());
        return entity;
    }

    public static List<UserEntity> mapDtosToEntities(List<UserDto> dtos) {
        if(dtos == null){
            return null;
        }
        List<UserEntity> entities = new ArrayList<>();
        dtos.forEach(userDto -> {
            entities.add(mapDtoToEntity(userDto));
        });

        return entities;
    }

    public static UserDto mapEntityToDto(UserEntity entity){
        if(entity == null){
            return null;
        }
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setAccountId(entity.getAccountId());
        // dto.setBadges(UserBadgeDto.mapEntitiesToDtos(entity.getBadges()));
        dto.setDownVotes(entity.getDownVotes());
        dto.setDisplayName(entity.getDisplayName());
        dto.setUpVotes(entity.getUpVotes());
        dto.setWebsiteUrl(entity.getWebsiteUrl());
        dto.setProfileImageUrl(entity.getProfileImageUrl());
        dto.setViews(entity.getViews());
        dto.setAboutMe(entity.getAboutMe());
        dto.setLocation(entity.getLocation());
        dto.setReputation(entity.getReputation());
        dto.setCreationDate(entity.getCreationDate());
        dto.setLastAccessDate(entity.getLastAccessDate());

        return dto;
    }

    public static List<UserDto> mapEntitiesToDtos(List<UserEntity> entities){
        if(entities == null){
            return null;
        }
        List<UserDto> dtos = new ArrayList<>();
        entities.forEach(userEntity -> {dtos.add(mapEntityToDto(userEntity));});
        return dtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReputation() {
        return reputation;
    }

    public void setReputation(Long reputation) {
        this.reputation = reputation;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public LocalDateTime getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(LocalDateTime lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(Long upVotes) {
        this.upVotes = upVotes;
    }

    public Long getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(Long downVotes) {
        this.downVotes = downVotes;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public List<UserBadgeDto> getBadges() {
        return badges;
    }

    public void setBadges(List<UserBadgeDto> badges) {
        this.badges = badges;
    }

}
