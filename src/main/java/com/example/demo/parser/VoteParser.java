package com.example.demo.parser;

import com.example.demo.parser.dto.PostDto;
import com.example.demo.parser.dto.VoteDto;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;

import java.time.LocalDateTime;

@Service
public class VoteParser extends AbstractParser<VoteDto>{

    @Override
    public VoteDto mapElementToDto(Element element){
        VoteDto dto = new VoteDto();
        if(element.hasAttribute("Id")) {
            dto.setId(Long.valueOf(element.getAttribute("Id")));
        }
        if(element.hasAttribute("CreationDate")){
            dto.setCreationDate(LocalDateTime.parse(element.getAttribute("CreationDate")));
        }
        if (element.hasAttribute("VoteTypeId")) {
            dto.setTypeId(Long.valueOf(element.getAttribute("VoteTypeId")));
        }
        if (element.hasAttribute("UserId")) {
            dto.setUserId(Long.valueOf(element.getAttribute("UserId")));
        }
        if (element.hasAttribute("PostId")) {
            PostDto post = new PostDto();
            post.setId(Long.valueOf(element.getAttribute("PostId")));
            dto.setPost(post);
        }
        return dto;
    }
    
}
