package com.example.demo.service;

import com.example.demo.parser.dto.CommentDto;
import com.example.demo.persistence.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void registerAll(List<CommentDto> commentDtos){
        commentRepository.saveAll(CommentDto.mapDtosToEntities(commentDtos));
    }
}
