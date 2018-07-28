package com.example.demo.controller;

import com.example.demo.persistence.entity.SystemUserEntity;
import com.example.demo.service.SystemUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class SystemUserController {
    private final SystemUserService systemUserService;

    public SystemUserController(SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }

    @PostMapping
    public SystemUserEntity register(@RequestBody SystemUserEntity systemUser){
        return systemUserService.registerNewSystemUser(systemUser);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<SystemUserEntity> getUsers(){
        return systemUserService.getUsers();
    }
}
