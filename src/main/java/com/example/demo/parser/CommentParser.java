package com.example.demo.parser;

import com.example.demo.parser.dto.CommentDto;
import com.example.demo.parser.dto.PostDto;
import com.example.demo.parser.dto.UserDto;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;

import java.time.LocalDateTime;

@Service
public class CommentParser extends AbstractParser<CommentDto> {

    @Override
    public CommentDto mapElementToDto(Element element){
        CommentDto dto = new CommentDto();
        if(element.hasAttribute("Id")) {
            dto.setId(Long.valueOf(element.getAttribute("Id")));
        }
        if (element.hasAttribute("Score")) {
            dto.setScore(Long.valueOf(element.getAttribute("Score")));
        }
        if (element.hasAttribute("Text")) {
            dto.setText(element.getAttribute("Text"));
        }
        if (element.hasAttribute("CreationDate")) {
            dto.setCreationDate(LocalDateTime.parse(element.getAttribute("CreationDate")));
        }
        if (element.hasAttribute("UserId")) {
            UserDto user = new UserDto();
            user.setId(Long.valueOf(element.getAttribute("UserId")));
            dto.setUser(user);
        }
        if (element.hasAttribute("PostId")) {
            PostDto post = new PostDto();
            post.setId(Long.valueOf(element.getAttribute("PostId")));
            dto.setPost(post);
        }
        return dto;
    }
}
