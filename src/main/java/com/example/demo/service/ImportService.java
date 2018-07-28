package com.example.demo.service;

import com.example.demo.parser.*;
import com.example.demo.parser.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.SECONDS;

@Service
public class ImportService {
    private final UserParser userParser;
    private final UserBadgeParser userBadgeParser;
    private final TagParser tagParser;
    private final PostParser postParser;
    private final PostLinkParser postLinkParser;
    private final CommentParser commentParser;
    private final VoteParser voteParser;

    private final UserService userService;
    private final CommentService commentService;
    private final PostLinkService postLinkService;
    private final PostService postService;
    private final VoteService voteService;
    private final UserBadgeService userBadgeService;
    private final BadgeService badgeService;
    private final TagService tagService;

    @Autowired
    public ImportService(UserParser userParser, UserBadgeParser userBadgeParser,
                         TagParser tagParser, PostParser postParser,
                         PostLinkParser postLinkParser, CommentParser commentParser,
                         VoteParser voteParser, UserService userService,
                         CommentService commentService, PostLinkService postLinkService,
                         PostService postService, VoteService voteService,
                         UserBadgeService userBadgeService, BadgeService badgeService,
                         TagService tagService) throws Exception {
        this.userParser = userParser;
        this.userBadgeParser = userBadgeParser;
        this.tagParser = tagParser;
        this.postParser = postParser;
        this.postLinkParser = postLinkParser;
        this.commentParser = commentParser;
        this.voteParser = voteParser;
        this.userService = userService;
        this.commentService = commentService;
        this.postLinkService = postLinkService;
        this.postService = postService;
        this.voteService = voteService;
        this.userBadgeService = userBadgeService;
        this.badgeService = badgeService;
        this.tagService = tagService;
    }

    public void importData(String usersXmlPath,String userBadgeXMLPath,String tagXMLPath,String postXMLPath,String postLinkXMLPath,String commentXMLPath,String voteXMLPath) throws Exception {
        try {

            //System.out.println("Parsing:start "+ LocalTime.now());
            LocalTime parsingStart = LocalTime.now();
            List<UserDto> userDtos = userParser.parse(usersXmlPath);
            List<UserBadgeDto> userBadgeDtos = userBadgeParser.parse(userBadgeXMLPath);
            List<TagDto> tagDtos = tagParser.parse(tagXMLPath);
            List<PostDto> postDtos = postParser.parse(postXMLPath);
            List<PostLinkDto> postLinkDtos = postLinkParser.parse(postLinkXMLPath);
            List<CommentDto> commentDtos = commentParser.parse(commentXMLPath);
            List<VoteDto> voteDtos = voteParser.parse(voteXMLPath);

            LocalTime parsingEnd = LocalTime.now();
            long parsingDuration = SECONDS.between(parsingStart,parsingEnd);

            //insert

            //USERS
            LocalTime userInsertStart = LocalTime.now();
            userDtos = userService.registerAll(userDtos);

            LocalTime userInsertEnd = LocalTime.now();
            long userInsertDuration = SECONDS.between(userInsertStart,userInsertEnd);

            //------------------------------------------------------------------------
            //BADGES
            LocalTime badgeInsertStart = LocalTime.now();

            Set<BadgeDto> badges = new HashSet<>();
            userBadgeDtos.forEach(userBadgeDto -> {
                badges.add(userBadgeDto.getBadge());
            });

            List<BadgeDto> savedBadges = badgeService.registerAll(badges);

            userBadgeDtos.forEach(userBadgeDto ->{

                String badgeName = userBadgeDto.getBadge().getName();
                BadgeDto dto = savedBadges.stream().filter(badgeDto ->
                                Objects.equals(badgeDto.getName(),badgeName))
                                .findFirst()
                                .orElse(null);
                userBadgeDto.setBadge(dto);

            });

            userBadgeService.registerAll(userBadgeDtos);
            LocalTime badgeInsertEnd = LocalTime.now();
            long badgeInsertDuration = SECONDS.between(badgeInsertStart,badgeInsertEnd);

            //------------------------------------------------------------------------
            //TAGS AND POSTS

            LocalTime tagInsertStart = LocalTime.now();

            tagDtos = tagService.registerAll(tagDtos);

            List<TagDto> finalTagDtos = tagDtos;
            List<UserDto> finalUserDtos = userDtos;

            postDtos.forEach(postDto -> {
                List<TagDto> tags = postDto.getTags();
                List<TagDto> existingTags = new ArrayList<>();

                if(tags != null) {
                    tags.forEach(tagDto -> {
                        TagDto dto = finalTagDtos.stream().filter(tag ->
                                Objects.equals(tag.getName(),tagDto.getName()))
                                .findFirst()
                                .orElse(null);

                        if (dto != null) {
                            existingTags.add(dto);
                        }
                    });
                }

                if(postDto.getLastEditor() != null &&
                        null == finalUserDtos.stream().filter(userDto -> Objects.equals(userDto.getId(),postDto.getLastEditor().getId()))
                                .findFirst().orElse(null)){
                    postDto.setLastEditor(null);
                }

                if(postDto.getOwnerUser() != null &&
                        null == finalUserDtos.stream().filter(userDto -> Objects.equals(userDto.getId(),postDto.getOwnerUser().getId()))
                                .findFirst().orElse(null)){
                    postDto.setOwnerUser(null);
                }

                postDto.setTags(existingTags);
            });

            LocalTime tagInsertEnd = LocalTime.now();
            long taginsertDuration = SECONDS.between(tagInsertStart,tagInsertEnd);

            LocalTime postInsertStart = LocalTime.now();
            postDtos = postService.registerAll(postDtos);
            LocalTime postInsertEnd = LocalTime.now();
            long postInsertDuration = SECONDS.between(postInsertStart,postInsertEnd);

            //------------------------------------------------------------------------
            //COMMENTS

            LocalTime commentInsertStart = LocalTime.now();
            List<CommentDto> existingComments = new ArrayList<>();

            List<PostDto> finalPostDtos = postDtos;
            commentDtos.forEach(commentDto -> {
                if(null != finalPostDtos.stream().filter(postDto -> Objects.equals(postDto.getId(),commentDto.getPost().getId()))
                        .findFirst().orElse(null)){
                    existingComments.add(commentDto);
                }
            });
            commentService.registerAll(existingComments);

            LocalTime commentInsertEnd = LocalTime.now();
            long commentInsertDuration = SECONDS.between(commentInsertStart,commentInsertEnd);

            //------------------------------------------------------------------------
            //POSTLINKS

            LocalTime postLinkInsertStart = LocalTime.now();
            List<PostLinkDto> existingPostLinks = new ArrayList<>();
            postLinkDtos.forEach(postLinkDto -> {
                if(null != finalPostDtos.stream().filter(postDto -> Objects.equals(postDto.getId(),postLinkDto.getPost().getId()))
                        .findFirst().orElse(null)){
                    existingPostLinks.add(postLinkDto);
                }
            });
            postLinkService.registerAll(existingPostLinks);
            LocalTime postLinkInsertEnd = LocalTime.now();
            long postLinkInsertDuration = SECONDS.between(postLinkInsertStart,postLinkInsertEnd);

            //------------------------------------------------------------------------
            //VOTES

            LocalTime voteInsertStart = LocalTime.now();
            List<VoteDto> existingVotes = new ArrayList<>();
            voteDtos.forEach(voteDto -> {
                if(null != finalPostDtos.stream().filter(postDto -> Objects.equals(postDto.getId(),voteDto.getPost().getId()))
                        .findFirst().orElse(null)){
                    existingVotes.add(voteDto);
                }
            });

            voteService.registerAll(existingVotes);
            LocalTime voteInsertEnd = LocalTime.now();
            long voteInsertDuration = SECONDS.between(voteInsertStart,voteInsertEnd);            System.out.println("Users:      " + "{ " + userInsertDuration + " }");

            //------------------------------------------------------------------------

            System.out.println("Parsing:    " + "{" + parsingDuration+ "}");
            System.out.println("Users:      " + "{" + userInsertDuration + "}");
            System.out.println("Badges:     " + "{" + badgeInsertDuration + "}");
            System.out.println("Tags:       " + "{" + taginsertDuration + "}");
            System.out.println("Posts:      " + "{" + postInsertDuration + "}");
            System.out.println("Comments:   " + "{" + commentInsertDuration + "}");
            System.out.println("PostLinks:  " + "{" + postLinkInsertDuration + "}");
            System.out.println("Votes:      " + "{" + voteInsertDuration + "}");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new Exception("Import failed");
        }
    }
}