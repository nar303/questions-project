package com.example.demo.service;

import com.example.demo.persistence.entity.SystemUserEntity;
import com.example.demo.persistence.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUserService {
    private final SystemUserRepository systemUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SystemUserService(SystemUserRepository systemUserRepository, PasswordEncoder passwordEncoder) {
        this.systemUserRepository = systemUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public SystemUserEntity registerNewSystemUser(SystemUserEntity systemUser){
        SystemUserEntity registeredUser = new SystemUserEntity();
        registeredUser.setUserName(systemUser.getUserName());
        registeredUser.setPassword(passwordEncoder.encode(systemUser.getPassword()));
        registeredUser.setRoles(systemUser.getRoles());

        return systemUserRepository.save(registeredUser);
    }

    public List<SystemUserEntity> getUsers(){
        return systemUserRepository.findAll();
    }
}
