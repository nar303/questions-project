package com.example.demo.controller;

import com.example.demo.parser.dto.PostDto;
import com.example.demo.service.PostService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private final PostService postService;

    public MainController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/search/{query}")
    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('USER')")
    public List<PostDto> searchPosts(@PathVariable String query, @RequestParam(required = false) Integer page){
        List<PostDto> posts = null;
        if(page != null) {
            posts = postService.search(query,page);
        } else {
            posts = postService.search(query,1);
        }
        return posts;
    }
}
