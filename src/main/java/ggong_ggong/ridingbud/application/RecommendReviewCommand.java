package ggong_ggong.ridingbud.application;

import ggong_ggong.ridingbud.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RecommendReviewCommand extends SelfValidating<RecommendReviewCommand> {
    @NotNull(message = "사용자 ID가 누락되었습니다.")
    private Long userId;
    @NotNull(message = "리뷰 ID가 누락되었습니다.")
    private Long reviewId;
    @NotNull(message = "생성 시간이 누락되었습니다.")
    private LocalDateTime createdTime;

    @Builder
    public RecommendReviewCommand(Long userId, Long reviewId, LocalDateTime createdTime) {
        this.userId = userId;
        this.reviewId = reviewId;
        this.createdTime = createdTime;
        this.validateSelf();
    }
}
