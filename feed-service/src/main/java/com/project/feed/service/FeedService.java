package com.project.feed.service;

import com.project.feed.dto.ContentDTO;
import com.project.feed.entity.FollowedCreator;
import com.project.feed.repository.FollowedCreatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Service to fetch posts of followed creators from content-service.
 */
@Service
@RequiredArgsConstructor
public class FeedService {

    private final RestTemplate restTemplate;
    private final FollowedCreatorRepository followedCreatorRepository;

    @Value("${content.service.url}")
    private String contentServiceUrl;

    /**
     * Returns feed of followed creators' posts for a given user.
     */
    public List<ContentDTO> getFeedForUser(Long userId) {
        List<FollowedCreator> followed = followedCreatorRepository.findByUserId(userId);
        List<Long> creatorIds = followed.stream()
                .map(FollowedCreator::getCreatorId)
                .toList();

        List<ContentDTO> feed = new ArrayList<>();

        for (Long creatorId : creatorIds) {
            String url = contentServiceUrl + creatorId + "/posts";
            ContentDTO[] posts = restTemplate.getForObject(url, ContentDTO[].class);
            if (posts != null) {
                feed.addAll(List.of(posts));
            }
        }

        return feed;
    }

    // Used by POST API (passing creatorIds manually)
    public List<ContentDTO> getFeedByCreatorIds(List<Long> creatorIds) {
        List<ContentDTO> feed = new ArrayList<>();

        for (Long creatorId : creatorIds) {
            String url = contentServiceUrl + creatorId + "/posts";
            ContentDTO[] posts = restTemplate.getForObject(url, ContentDTO[].class);
            if (posts != null) {
                feed.addAll(List.of(posts));
            }
        }

        return feed;
    }
}
