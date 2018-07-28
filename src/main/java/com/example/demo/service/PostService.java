package com.example.demo.service;

import com.example.demo.parser.dto.PostDto;
import com.example.demo.persistence.entity.PostEntity;
import com.example.demo.persistence.repository.PostRepository;
import com.example.demo.persistence.repository.TagRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    public PostService(PostRepository postRepository, TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
    }

    public PostEntity register(PostEntity post){
        return postRepository.save(post);
    }

    public List<PostDto> registerAll(List<PostDto> postDtos){
        return PostDto.mapEntitiesToDtos(postRepository.saveAll(PostDto.mapDtosToEntities(postDtos)));
    }

    public PostEntity getById(Long id){
        return postRepository.getOne(id);
    }

    public boolean existsById(Long id){
        return postRepository.existsById(id);
    }

    private Pageable gotoPage(int page) {
        Pageable request = new PageRequest(page,10);
        return request;
    }

    public List<PostDto> search(String searchQuery, int page){
        List<PostEntity> posts =  postRepository.getPostByQuery(searchQuery,gotoPage(page - 1));
        return PostDto.mapEntitiesToDtos(posts);
    }
}
