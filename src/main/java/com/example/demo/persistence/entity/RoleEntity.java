package com.example.demo.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEntity {

    public enum RoleEnum{
        USER,
        ADMIN;

        RoleEnum() {}

    }

    @Id
    private Long id;

    //@Enumerated(EnumType.STRING)
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
