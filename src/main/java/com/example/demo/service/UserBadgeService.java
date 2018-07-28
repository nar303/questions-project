package com.example.demo.service;

import com.example.demo.parser.dto.UserBadgeDto;
import com.example.demo.persistence.entity.UserBadgeEntity;
import com.example.demo.persistence.repository.UserBadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBadgeService {
    private final UserBadgeRepository userBadgeRepository;

    @Autowired
    public UserBadgeService(UserBadgeRepository userBadgeRepository) {
        this.userBadgeRepository = userBadgeRepository;
    }

    public void registerAll(List<UserBadgeDto> userBadges){
        userBadgeRepository.saveAll(UserBadgeDto.mapDtosToEntities(userBadges));
    }

    public UserBadgeEntity register(UserBadgeEntity userBadge){
        return userBadgeRepository.save(userBadge);
    }
}
