package ggong_ggong.ridingbud.api.req;

import lombok.Getter;

@Getter
public class CreateReviewRequest {

    private Long courseId;
    private String content;
}
