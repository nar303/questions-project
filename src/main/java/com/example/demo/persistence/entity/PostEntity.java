package com.example.demo.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "post")
public class PostEntity {
    @Id
    private Long id;

    @Column
    private Long postTypeId;

    @Column
    private LocalDateTime creationDate;

    @Column
    private Long score;

    @Column
    private Long viewCount;

    @Column(columnDefinition = "Text")
    private String body;

    @Column
    private LocalDateTime lastActivityDate;

    @Column(columnDefinition = "Text")
    private String title;

    @Column
    private Long answerCount;

    @Column
    private Long commentCount;

    @Column
    private Long favoriteCount;

    @Column
    private LocalDateTime closedDate;

    @Column
    private LocalDateTime communityOwnedDate;


    @ManyToMany
    private List<TagEntity> tags;

    @ManyToOne
    private UserEntity ownerUser;

    // @OneToOne
    //private PostEntity acceptedAnswer;

    @ManyToOne
    @JoinColumn(name = "last_editor_id",referencedColumnName = "id")
    private UserEntity lastEditor;

    @Column
    private LocalDateTime lastEditDate;

    //@ManyToOne
    //private PostEntity parent;

    @OneToMany
    @JoinColumn(name = "post_id")
    private List<VoteEntity> votes;

    @OneToMany
    @JoinColumn(name = "post_id")
    private List<CommentEntity> comments;

    @OneToMany
    @JoinColumn(name = "post_id")
    private List<PostLinkEntity> postLinks;

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

    public UserEntity getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(UserEntity ownerUser) {
        this.ownerUser = ownerUser;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }

    public UserEntity getLastEditor() {
        return lastEditor;
    }

    public void setLastEditor(UserEntity lastEditor) {
        this.lastEditor = lastEditor;
    }

    public LocalDateTime getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(LocalDateTime lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public List<VoteEntity> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteEntity> votes) {
        this.votes = votes;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public List<PostLinkEntity> getPostLinks() {
        return postLinks;
    }

    public void setPostLinks(List<PostLinkEntity> postLinks) {
        this.postLinks = postLinks;
    }

    @Override
    public String toString() {
        return "PostEntity{" +
                "id=" + id +
                ", postTypeId=" + postTypeId +
                ", creationDate=" + creationDate +
                ", score=" + score +
                ", viewCount=" + viewCount +
                ", body='" + body + '\'' +
                ", lastActivityDate=" + lastActivityDate +
                ", title='" + title + '\'' +
                ", answerCount=" + answerCount +
                ", commentCount=" + commentCount +
                ", favoriteCount=" + favoriteCount +
                ", closedDate=" + closedDate +
                ", communityOwnedDate=" + communityOwnedDate +
                ", ownerUser=" + ownerUser +
                ", tags=" + tags +
                ", lastEditor=" + lastEditor +
                ", lastEditDate=" + lastEditDate +
                ", votes=" + votes +
                ", comments=" + comments +
                ", postLinks=" + postLinks +
                '}';
    }
}
