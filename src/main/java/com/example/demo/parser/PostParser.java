package com.example.demo.parser;

import com.example.demo.parser.dto.PostDto;
import com.example.demo.parser.dto.TagDto;
import com.example.demo.parser.dto.UserDto;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostParser extends AbstractParser<PostDto> {

    @Override
    public PostDto mapElementToDto(Element element){
        PostDto dto = new PostDto();
        if(element.hasAttribute("Id")){
            dto.setId(Long.valueOf(element.getAttribute("Id")));
        }
        if (element.hasAttribute("PostTypeId")) {
            dto.setPostTypeId(Long.valueOf(element.getAttribute("PostTypeId")));
        }
        if (element.hasAttribute("CreationDate")) {
            dto.setCreationDate(LocalDateTime.parse(element.getAttribute("CreationDate")));
        }
        if (element.hasAttribute("Score")) {
            dto.setScore(Long.valueOf(element.getAttribute("Score")));
        }
        if (element.hasAttribute("ViewCount")) {
            dto.setViewCount(Long.valueOf(element.getAttribute("ViewCount")));
        }
        if (element.hasAttribute("Title")) {
            dto.setTitle(element.getAttribute("Title"));
        }
        if (element.hasAttribute("Body")) {
            dto.setBody(element.getAttribute("Body"));
        }
        if (element.hasAttribute("LastActivityDate")) {
            dto.setLastActivityDate(LocalDateTime.parse(element.getAttribute("LastActivityDate")));
        }
        if (element.hasAttribute("OwnerUserId")) {
            UserDto ownerUser = new UserDto();
            Long ownerUserId = Long.valueOf(element.getAttribute("OwnerUserId"));
            if (ownerUserId != -1L) {
                ownerUser.setId(ownerUserId);
                dto.setOwnerUser(ownerUser);
            }
        }
        if (element.hasAttribute("LastEditorUserId")) {
            UserDto lastEditor = new UserDto();
            Long lastEditorId = Long.valueOf(element.getAttribute("LastEditorUserId"));
            if (lastEditorId != -1L) {
                lastEditor.setId(lastEditorId);
                dto.setLastEditor(lastEditor);
            }
        }
        if (element.hasAttribute("AnswerCount")) {
            dto.setAnswerCount(Long.valueOf(element.getAttribute("AnswerCount")));
        }
        if (element.hasAttribute("CommentCount")) {
            dto.setCommentCount(Long.valueOf(element.getAttribute("CommentCount")));
        }
        if (element.hasAttribute("FavoriteCount")) {
            dto.setFavoriteCount(Long.valueOf(element.getAttribute("FavoriteCount")));
        }
        if (element.hasAttribute("LastEditDate")) {
            dto.setLastEditDate(LocalDateTime.parse(element.getAttribute("LastEditDate")));
        }
        if (element.hasAttribute("ClosedDate")) {
            dto.setClosedDate(LocalDateTime.parse(element.getAttribute("ClosedDate")));
        }
        if (element.hasAttribute("CommunityOwnedDate")) {
            dto.setCommunityOwnedDate(LocalDateTime.parse(element.getAttribute("CommunityOwnedDate")));
        }
        if (element.hasAttribute("Tags")) {
            String tag = element.getAttribute("Tags");
            tag = tag.substring(1, tag.length() - 1);

            String tags[] = tag.split("><");
            List<TagDto> tagDtos = new ArrayList<>();

            for (String tagName :
                    tags) {
                TagDto tagDto = new TagDto();
                tagDto.setName(tagName);
                tagDtos.add(tagDto);
            }

            dto.setTags(tagDtos);
        }
        return dto;
    }
}