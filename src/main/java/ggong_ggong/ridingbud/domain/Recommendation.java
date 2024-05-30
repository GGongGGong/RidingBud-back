package ggong_ggong.ridingbud.domain;

import ggong_ggong.ridingbud.application.RecommendReviewCommand;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE) @Builder
@Getter
public class Recommendation {

    @EmbeddedId
    private RecommendationId recommendationId;

    private LocalDateTime createdTime;

    public static Recommendation from(RecommendReviewCommand command) {
        return Recommendation.builder()
                .recommendationId(
                        RecommendationId.of(command.getUserId(), command.getReviewId())
                )
                .createdTime(command.getCreatedTime())
                .build();
    }
}
