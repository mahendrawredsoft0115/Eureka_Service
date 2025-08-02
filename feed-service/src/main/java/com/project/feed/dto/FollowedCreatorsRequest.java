package com.project.feed.dto;

import lombok.Data;

import java.util.List;

/**
 * Request body to pass list of followed creators.
 */
@Data
public class FollowedCreatorsRequest {
    private List<Long> creatorIds;
}
