package com.example.demo.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_badge")
public class UserBadgeEntity {
    @Id
    private Long id;

    @ManyToOne
    private BadgeEntity badge;

    @Column
    private LocalDateTime date;

    @Column
    private Byte badgeClass;

    @Column
    private Boolean tagBased;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BadgeEntity getBadge() {
        return badge;
    }

    public void setBadge(BadgeEntity badge) {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
