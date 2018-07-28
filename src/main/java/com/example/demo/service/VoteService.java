package com.example.demo.service;

import com.example.demo.parser.dto.VoteDto;
import com.example.demo.persistence.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {
    private final VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public void registerAll(List<VoteDto> voteDtos){
        voteRepository.saveAll(VoteDto.mapDtosToEntities(voteDtos));
    }
}
