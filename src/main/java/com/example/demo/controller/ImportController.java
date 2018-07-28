package com.example.demo.controller;

import com.example.demo.parser.dto.BadgeDto;
import com.example.demo.service.ImportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.SECONDS;


@RestController
@RequestMapping("/parsing")
public class ImportController {
    private final ImportService importService;

    // You can download the files from https://archive.org/details/stackexchange
    private static final String PATH_TO_FILE_WITH_NAME =
            "/Users/Admin/IdeaProjects/It-Giants/src/main/resources/ai.meta.stackexchange.com";
    private static final String COMMENTS = PATH_TO_FILE_WITH_NAME + "/Comments.xml";
    private static final String USERS = PATH_TO_FILE_WITH_NAME + "/Users.xml";
    private static final String BADGES = PATH_TO_FILE_WITH_NAME + "/Badges.xml";
    private static final String TAGS = PATH_TO_FILE_WITH_NAME + "/Tags.xml";
    private static final String POSTLINKS = PATH_TO_FILE_WITH_NAME + "/PostLinks.xml";
    private static final String VOTES = PATH_TO_FILE_WITH_NAME + "/Votes.xml";
    private static final String POSTS = PATH_TO_FILE_WITH_NAME + "/Posts.xml";

    public ImportController(ImportService importService) {
        this.importService = importService;
    }

    @GetMapping
    public BadgeDto importData() throws Exception {
        try {
            LocalTime start = LocalTime.now();
            importService.importData(USERS,BADGES,TAGS,POSTS,POSTLINKS,COMMENTS,VOTES);
            LocalTime end = LocalTime.now();
            System.out.println("Import: " + SECONDS.between(start,end));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new BadgeDto();
    }
}
