package com.example.demo.service;

import com.example.demo.parser.dto.TagDto;
import com.example.demo.persistence.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<TagDto> registerAll(List<TagDto> tagDtos){
        return TagDto.mapEntitiesToDtos(tagRepository.saveAll(TagDto.mapDtosToEntities(tagDtos)));
    }

    public TagDto getByName(String name){
        return TagDto.mapEntityToDto(tagRepository.findByName(name));
    }
}
