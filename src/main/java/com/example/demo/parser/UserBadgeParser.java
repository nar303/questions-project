package com.example.demo.parser;

import com.example.demo.parser.dto.BadgeDto;
import com.example.demo.parser.dto.UserBadgeDto;
import com.example.demo.parser.dto.UserDto;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;

import java.time.LocalDateTime;

@Service
public class UserBadgeParser extends AbstractParser<UserBadgeDto> {

    @Override
    public UserBadgeDto mapElementToDto(Element element){
        UserBadgeDto dto = new UserBadgeDto();
        if(element.hasAttribute("Id")) {
            dto.setId(Long.valueOf(element.getAttribute("Id")));
        }
        if(element.hasAttribute("Date")){
            dto.setDate(LocalDateTime.parse(element.getAttribute("Date")));
        }
        if(element.hasAttribute("Class")){
            dto.setBadgeClass(Byte.valueOf(element.getAttribute("Class")));
        }
        if(element.hasAttribute("TagBased")) {
            dto.setTagBased(Boolean.valueOf(element.getAttribute("TagBased")));
        }
        if(element.hasAttribute("Name")) {
            BadgeDto badge = new BadgeDto();
            badge.setName(element.getAttribute("Name"));
            dto.setBadge(badge);
        }
        if(element.hasAttribute("UserId")) {
            UserDto user = new UserDto();
            user.setId(Long.valueOf(element.getAttribute("UserId")));
            dto.setUser(user);
        }
        return dto;
    }
}
