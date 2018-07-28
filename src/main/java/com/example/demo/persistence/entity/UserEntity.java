package com.example.demo.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    private Long id;

    @Column
    private Long reputation;

    @Column
    private LocalDateTime creationDate;

    @Column
    private String displayName;

    @Column
    private LocalDateTime lastAccessDate;

    @Column
    private String location;

    @Column(columnDefinition = "Text")
    private String aboutMe;

    @Column
    private Long views;

    @Column
    private Long upVotes;

    @Column
    private Long downVotes;

    @Column
    private Long accountId;

    @Column
    private String profileImageUrl;

    @Column
    private String websiteUrl;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<UserBadgeEntity> badges;

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

    public LocalDateTime getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(LocalDateTime lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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

    public List<UserBadgeEntity> getBadges() {
        return badges;
    }

    public void setBadges(List<UserBadgeEntity> badges) {
        this.badges = badges;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", reputation=" + reputation +
                ", creationDate=" + creationDate +
                ", displayName='" + displayName + '\'' +
                ", lastAccessDate=" + lastAccessDate +
                ", location='" + location + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", views=" + views +
                ", upVotes=" + upVotes +
                ", downVotes=" + downVotes +
                ", accountId=" + accountId +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", badges=" + badges +
                '}';
    }
}
