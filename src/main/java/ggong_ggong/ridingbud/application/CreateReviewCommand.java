package ggong_ggong.ridingbud.application;

import ggong_ggong.ridingbud.SelfValidating;
import ggong_ggong.ridingbud.domain.Course;
import ggong_ggong.ridingbud.domain.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateReviewCommand extends SelfValidating<CreateReviewCommand> {

    @NotNull(message = "코스 ID가 누락되었습니다.")
    private Course course;
    @NotNull(message = "사용자 ID가 누락되었습니다.")
    private User user;
    @NotEmpty(message = "리뷰 내용은 누락되거나 빈 칸일 수 없습니다.")
    private String content;
    @NotNull(message = "리뷰 작성 시간이 누락되었습니다.")
    private LocalDateTime createdTime;

    @Builder
    public CreateReviewCommand(Course course, User user, String content, LocalDateTime createdTime) {
        this.course = course;
        this.user = user;
        this.content = content;
        this.createdTime = createdTime;
        this.validateSelf();
    }
}
