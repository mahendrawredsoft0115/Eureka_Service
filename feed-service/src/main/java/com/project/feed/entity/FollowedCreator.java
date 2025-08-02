package com.project.feed.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Entity representing a user following a creator.
 */
@Entity
@Table(name = "followed_creators")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowedCreator {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long creatorId;
}
