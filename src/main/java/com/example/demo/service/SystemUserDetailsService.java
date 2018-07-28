package com.example.demo.service;

import com.example.demo.persistence.entity.RoleEntity;
import com.example.demo.persistence.entity.SystemUserEntity;
import com.example.demo.persistence.repository.RoleRepository;
import com.example.demo.persistence.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SystemUserDetailsService implements UserDetailsService {
    private final SystemUserRepository systemUserRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public SystemUserDetailsService(SystemUserRepository systemUserRepository, RoleRepository roleRepository) {
        this.systemUserRepository = systemUserRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SystemUserEntity user = systemUserRepository.findByUserName(userName);
        List<GrantedAuthority> roles = new ArrayList<>();
        List<RoleEntity> roleEntities = roleRepository.getRolesByUserName(userName);

        roleEntities.forEach(roleEntity -> {
            roles.add(new SimpleGrantedAuthority(roleEntity.getRole()));
        });

        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getUserName(),
                        user.getPassword(),
                        roles);

        return userDetails;
    }
}
