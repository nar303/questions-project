package com.example.demo.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "system_user")
public class SystemUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;

    private String password;

    @ManyToMany
    private List<RoleEntity> roles;

    public SystemUserEntity(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public SystemUserEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
}
