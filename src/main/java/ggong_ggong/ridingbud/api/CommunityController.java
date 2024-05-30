package ggong_ggong.ridingbud.api;

import ggong_ggong.ridingbud.api.req.CreateReviewRequest;
import ggong_ggong.ridingbud.application.CreateReviewCommand;
import ggong_ggong.ridingbud.application.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CommunityController {

    private final ReviewService reviewService;

    @PostMapping("/review")
    public ResponseEntity<?> enrollReview(@RequestBody CreateReviewRequest request) {
        // TODO: AccessToken에서 UserID 빼오는 코드 작성
        Long userId = 1L;

        reviewService.enrollReview(
                CreateReviewCommand.builder()
                        .courseId(request.getCourseId())
                        .userId(userId)
                        .content(request.getContent())
                        .createdTime(LocalDateTime.now())
                        .build()
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
