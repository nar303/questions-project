package com.example.demo.service;

import com.example.demo.parser.dto.PostLinkDto;
import com.example.demo.persistence.repository.PostLinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostLinkService {
    private final PostLinkRepository postLinkRepository;

    public PostLinkService(PostLinkRepository postLinkRepository) {
        this.postLinkRepository = postLinkRepository;
    }

    public void registerAll(List<PostLinkDto> postLinkDtos){
        postLinkRepository.saveAll(PostLinkDto.mapDtosToEntities(postLinkDtos));
    }
}
