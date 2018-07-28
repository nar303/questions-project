package com.example.demo.service;

import com.example.demo.parser.dto.BadgeDto;
import com.example.demo.persistence.repository.BadgeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BadgeService {
    private final BadgeRepository badgeRepository;

    public BadgeService(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }


    public BadgeDto register(BadgeDto badgeDto){
        return BadgeDto.mapEntityToDto(badgeRepository.save(BadgeDto.mapDtoToEntity(badgeDto)));
    }

    public List<BadgeDto> registerAll(List<BadgeDto> badgeDtos){
        return BadgeDto.mapEntitiesToDtos(badgeRepository.saveAll(BadgeDto.mapDtosToEntities(badgeDtos)));
    }

    public List<BadgeDto> registerAll(Set<BadgeDto> badgeDtos){
        List<BadgeDto> list = new ArrayList<>(badgeDtos);
        return BadgeDto.mapEntitiesToDtos(badgeRepository.saveAll(BadgeDto.mapDtosToEntities(list)));
    }

    public boolean existsByName(String badgeName){
        return badgeRepository.existsByName(badgeName);
    }

    public BadgeDto getByName(String badgeName){
        return BadgeDto.mapEntityToDto(badgeRepository.getByName(badgeName));
    }

}
