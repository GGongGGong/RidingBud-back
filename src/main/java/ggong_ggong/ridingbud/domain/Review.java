package ggong_ggong.ridingbud.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE) @Builder
@Getter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private Long courseId;
    private Long userId;

    private String content;
    private LocalDateTime createdTime;

    public static Review from(CreateReviewCommand command) {
        return Review.builder()
                .courseId(command.getCourseId())
                .userId(command.getUserId())
                .content(command.getContent())
                .createdTime(command.getCreatedTime())
                .build();
    }
}
