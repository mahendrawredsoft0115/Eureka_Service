package com.project.feed.controller;

import com.project.feed.dto.ContentDTO;
import com.project.feed.dto.FollowedCreatorsRequest;
import com.project.feed.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for user's feed based on followed creators.
 */
@RestController
@RequestMapping("/api/feed")
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @PostMapping
    public List<ContentDTO> getFeed(@RequestBody FollowedCreatorsRequest request) {
        return feedService.getFeedByCreatorIds(request.getCreatorIds());
    }

    @GetMapping("/{userId}")
    public List<ContentDTO> getFeedByUserId(@PathVariable Long userId) {
        return feedService.getFeedForUser(userId);
    }



}
