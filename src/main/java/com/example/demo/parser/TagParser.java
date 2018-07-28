package com.example.demo.parser;

import com.example.demo.parser.dto.TagDto;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;

@Service
public class TagParser extends AbstractParser<TagDto> {

    public TagDto mapElementToDto(Element element){
        TagDto dto = new TagDto();
        if(element.hasAttribute("Id")) {
            dto.setId(Long.valueOf(element.getAttribute("Id")));
        }
        if (element.hasAttribute("TagName")) {
            dto.setName(element.getAttribute("TagName"));
        }
        if (element.hasAttribute("Count")) {
            dto.setCount(Long.valueOf(element.getAttribute("Count")));
        }
        if (element.hasAttribute("ExcerptPostId")) {
            dto.setExcerptPostId(Long.valueOf(element.getAttribute("ExcerptPostId")));
        }
        if (element.hasAttribute("WikiPostId")) {
            dto.setWikiPostId(Long.valueOf(element.getAttribute("WikiPostId")));
        }
        return dto;
    }
}

