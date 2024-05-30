package ggong_ggong.ridingbud.application;

import ggong_ggong.ridingbud.SelfValidating;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateReviewCommand extends SelfValidating<CreateReviewCommand> {

    @NotNull(message = "코스 ID가 누락되었습니다.")
    private Long courseId;
    @NotNull(message = "사용자 ID가 누락되었습니다.")
    private Long userId;
    @NotEmpty(message = "리뷰 내용은 누락되거나 빈 칸일 수 없습니다.")
    private String content;
    @NotNull(message = "리뷰 작성 시간이 누락되었습니다.")
    private LocalDateTime createdTime;

    @Builder
    public CreateReviewCommand(Long courseId, Long userId, String content, LocalDateTime createdTime) {
        this.courseId = courseId;
        this.userId = userId;
        this.content = content;
        this.createdTime = createdTime;
        this.validateSelf();
    }
}
