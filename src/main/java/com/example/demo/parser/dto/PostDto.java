package com.example.demo.parser.dto;

import com.example.demo.persistence.entity.PostEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDto {
    private Long id;
    private Long postTypeId;
    private LocalDateTime creationDate;
    private Long score;
    private Long viewCount;
    private String body;
    private LocalDateTime lastActivityDate;
    private String title;
    private Long answerCount;
    private Long commentCount;
    private Long favoriteCount;
    private LocalDateTime closedDate;
    private LocalDateTime communityOwnedDate;
    private UserDto ownerUser;
    private List<TagDto> tags;
    private UserDto lastEditor;
    private LocalDateTime lastEditDate;
    private List<VoteDto> votes;
    private List<CommentDto> comments;
    private List<PostLinkDto> postLinks;

    public static PostEntity mapDtoToEntity(PostDto dto) {
        if (dto == null) {
            return null;
        }
        PostEntity entity = new PostEntity();

        entity.setId(dto.getId());
        entity.setTags(TagDto.mapDtosToEntities(dto.getTags()));
        entity.setFavoriteCount(dto.getFavoriteCount());
        entity.setCommentCount(dto.getCommentCount());
        entity.setAnswerCount(dto.getAnswerCount());
        entity.setTitle(dto.getTitle());
        entity.setBody(dto.getBody());
        entity.setViewCount(dto.getViewCount());
        entity.setScore(dto.getScore());
        entity.setPostTypeId(dto.getPostTypeId());
        entity.setClosedDate(dto.getClosedDate());
        entity.setCommunityOwnedDate(dto.getCommunityOwnedDate());
        entity.setCreationDate(dto.getCreationDate());
        entity.setLastActivityDate(dto.getLastActivityDate());
        entity.setLastEditDate(dto.getLastEditDate());
        entity.setOwnerUser(UserDto.mapDtoToEntity(dto.getOwnerUser()));
        entity.setLastEditor(UserDto.mapDtoToEntity(dto.getLastEditor()));
        // entity.setComments(CommentDto.mapDtosToEntities(dto.getComments()));
        // entity.setPostLinks(PostLinkDto.mapDtosToEntities(dto.getPostLinks()));
        // entity.setVotes(VoteDto.mapDtosToEntities(dto.getVotes()));

        return entity;
    }

    public static List<PostEntity> mapDtosToEntities(List<PostDto> dtos) {
        if (dtos == null) {
            return null;
        }
        List<PostEntity> entities = new ArrayList<>();
        dtos.forEach(postDto -> {
            entities.add(mapDtoToEntity(postDto));
        });

        return entities;
    }

    public static PostDto mapEntityToDto(PostEntity entity){
        if(entity == null){
            return null;
        }
        PostDto dto = new PostDto();
        dto.setId(entity.getId());
        dto.setTags(TagDto.mapEntitiesToDtos(entity.getTags()));
        dto.setFavoriteCount(entity.getFavoriteCount());
        dto.setCommentCount(entity.getCommentCount());
        dto.setAnswerCount(entity.getAnswerCount());
        dto.setTitle(entity.getTitle());
        dto.setOwnerUser(UserDto.mapEntityToDto(entity.getOwnerUser()));
        dto.setBody(entity.getBody());
        dto.setViewCount(entity.getViewCount());
        dto.setScore(entity.getScore());
        dto.setPostTypeId(entity.getPostTypeId());
        dto.setClosedDate(entity.getClosedDate());
        dto.setCommunityOwnedDate(entity.getCommunityOwnedDate());
        dto.setCreationDate(entity.getCreationDate());
        dto.setLastActivityDate(entity.getLastActivityDate());
        dto.setLastEditDate(entity.getLastEditDate());
        dto.setLastEditor(UserDto.mapEntityToDto(entity.getLastEditor()));
//        dto.setComments(CommentDto.mapEntitiesToDtos(entity.getComments()));
//        dto.setPostLinks(PostLinkDto.mapEntitiesToDtos(entity.getPostLinks()));
//        dto.setVotes(VoteDto.mapEntitiesToDtos(entity.getVotes()));

        return dto;
    }

    public static List<PostDto> mapEntitiesToDtos(List<PostEntity> entities){
        if(entities == null){
            return null;
        }
        List<PostDto> dtos = new ArrayList<>();
        entities.forEach(postEntity -> {dtos.add(mapEntityToDto(postEntity));});
        return dtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(Long postTypeId) {
        this.postTypeId = postTypeId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(LocalDateTime lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Long answerCount) {
        this.answerCount = answerCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public Long getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Long favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public LocalDateTime getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(LocalDateTime closedDate) {
        this.closedDate = closedDate;
    }

    public LocalDateTime getCommunityOwnedDate() {
        return communityOwnedDate;
    }

    public void setCommunityOwnedDate(LocalDateTime communityOwnedDate) {
        this.communityOwnedDate = communityOwnedDate;
    }

    public UserDto getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(UserDto ownerUser) {
        this.ownerUser = ownerUser;
    }

    public List<TagDto> getTags() {
        return tags;
    }

    public void setTags(List<TagDto> tags) {
        this.tags = tags;
    }


    public UserDto getLastEditor() {
        return lastEditor;
    }

    public void setLastEditor(UserDto lastEditor) {
        this.lastEditor = lastEditor;
    }

    public LocalDateTime getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(LocalDateTime lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public List<VoteDto> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteDto> votes) {
        this.votes = votes;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public List<PostLinkDto> getPostLinks() {
        return postLinks;
    }

    public void setPostLinks(List<PostLinkDto> postLinks) {
        this.postLinks = postLinks;
    }


}
