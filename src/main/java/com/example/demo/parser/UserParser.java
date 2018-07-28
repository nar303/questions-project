package com.example.demo.parser;

import com.example.demo.parser.dto.UserDto;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;

import java.time.LocalDateTime;

@Service
public class UserParser extends AbstractParser<UserDto>{

    @Override
    public UserDto mapElementToDto(Element element){
        UserDto dto = new UserDto();
        if(element.hasAttribute("Id")) {
            dto.setId(Long.valueOf(element.getAttribute("Id")));
        }
        if(element.hasAttribute("Reputation")){
            dto.setReputation(Long.valueOf(element.getAttribute("Reputation")));
        }
        if(element.hasAttribute("CreationDate")){
            dto.setCreationDate(LocalDateTime.parse(element.getAttribute("CreationDate")));
        }
        if(element.hasAttribute("DisplayName")){
            dto.setDisplayName(element.getAttribute("DisplayName"));
        }
        if(element.hasAttribute("LastAccessDate")){
            dto.setCreationDate(LocalDateTime.parse(element.getAttribute("LastAccessDate")));
        }
        if(element.hasAttribute("Location")){
            dto.setLocation(element.getAttribute("Location"));
        }
        if(element.hasAttribute("AboutMe")){
            dto.setAboutMe(element.getAttribute("AboutMe"));
        }
        if(element.hasAttribute("Views")){
            dto.setViews(Long.valueOf(element.getAttribute("Views")));
        }
        if(element.hasAttribute("UpVotes")){
            dto.setUpVotes(Long.valueOf(element.getAttribute("UpVotes")));
        }
        if(element.hasAttribute("DownVotes")){
            dto.setDownVotes(Long.valueOf(element.getAttribute("DownVotes")));
        }
        if(element.hasAttribute("AccountId")){
            dto.setAccountId(Long.valueOf(element.getAttribute("AccountId")));
        }
        if(element.hasAttribute("ProfileImageUrl")){
            dto.setProfileImageUrl(element.getAttribute("ProfileImageUrl"));
        }
        if(element.hasAttribute("WebsiteUrl")){
            dto.setWebsiteUrl(element.getAttribute("WebsiteUrl"));
        }

        return dto;
    }
}
