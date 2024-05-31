package ggong_ggong.ridingbud.api.res;

import jakarta.persistence.Tuple;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
public class ReviewDto {

    private Long reviewId;
    private Long courseId;
    private Long userId;
    private String content;
    private String createdTime;
    private Long recommendations;

    public static ReviewDto of(Tuple tuple) {
        return ReviewDto.builder()
                .reviewId(tuple.get(0, Long.class))
                .courseId(tuple.get(2, Long.class))
                .userId(tuple.get(4, Long.class))
                .content(tuple.get(1, String.class))
                .createdTime(tuple.get(3, Timestamp.class).toLocalDateTime())
                .recommendations(tuple.get(5, Long.class))
                .build();
    }

    @Builder
    private ReviewDto(Long reviewId, Long courseId, Long userId, String content, LocalDateTime createdTime, Long recommendations) {
        this.reviewId = reviewId;
        this.courseId = courseId;
        this.userId = userId;
        this.content = content;
        this.createdTime = createdTime.toLocalDate().toString();
        this.recommendations = recommendations;
    }
}
