//package com.feed.service.dto;
package com.project.feed.dto;
import com.project.feed.enums.ContentType;
import com.project.feed.enums.FileType;
import com.project.feed.enums.Visibility;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO representing content from content-service.
 */
@Data
public class ContentDTO {
    private UUID id;
    private Long creatorId;
    private String title;
    private String description;
    private String filename;
    private String url;
    private Visibility visibility;
    private FileType fileType;
    private ContentType contentType;
    private BigDecimal price;
    private LocalDateTime uploadedAt;
}
