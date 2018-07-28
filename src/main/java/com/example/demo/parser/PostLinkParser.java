package com.example.demo.parser;

import com.example.demo.parser.dto.PostDto;
import com.example.demo.parser.dto.PostLinkDto;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;

import java.time.LocalDateTime;

@Service
public class PostLinkParser extends  AbstractParser<PostLinkDto> {

    @Override
    public PostLinkDto mapElementToDto(Element element){
        PostLinkDto dto = new PostLinkDto();
        if(element.hasAttribute("Id")) {
            dto.setId(Long.valueOf(element.getAttribute("Id")));
        }
        if(element.hasAttribute("CreationDate")){
            dto.setCreationDate(LocalDateTime.parse(element.getAttribute("CreationDate")));
        }
        if (element.hasAttribute("LinkTypeId")) {
            dto.setLinkTypeId(Long.valueOf(element.getAttribute("LinkTypeId")));
        }
        if (element.hasAttribute("RelatedPostId")) {
            PostDto relatedPost = new PostDto();
            relatedPost.setId(Long.valueOf(element.getAttribute("RelatedPostId")));
            dto.setRelatedPost(relatedPost);
        }
        if (element.hasAttribute("PostId")) {
            PostDto post = new PostDto();
            post.setId(Long.valueOf(element.getAttribute("PostId")));
            dto.setPost(post);
        }
        return dto;
    }
}
