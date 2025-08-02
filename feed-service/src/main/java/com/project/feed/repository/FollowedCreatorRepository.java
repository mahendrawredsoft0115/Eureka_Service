package com.project.feed.repository;

import com.project.feed.entity.FollowedCreator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Repository to fetch followed creators by user.
 */
public interface FollowedCreatorRepository extends JpaRepository<FollowedCreator, UUID> {

    List<FollowedCreator> findByUserId(Long userId);
}
