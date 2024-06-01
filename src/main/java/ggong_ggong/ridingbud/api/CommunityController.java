package ggong_ggong.ridingbud.api;

import ggong_ggong.ridingbud.api.req.CreateReviewRequest;
import ggong_ggong.ridingbud.api.req.RatingCourseRequest;
import ggong_ggong.ridingbud.api.req.RecommendReviewRequest;
import ggong_ggong.ridingbud.api.res.FindReviewsResponse;
import ggong_ggong.ridingbud.api.res.ReviewDto;
import ggong_ggong.ridingbud.application.*;
import ggong_ggong.ridingbud.domain.Course;
import ggong_ggong.ridingbud.domain.RecommendationId;
import ggong_ggong.ridingbud.domain.User;
import ggong_ggong.ridingbud.enums.ReviewSortKey;
import ggong_ggong.ridingbud.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
@Slf4j
public class CommunityController {

    private final ReviewService reviewService;
    private final CourseService courseService;
    private final UserRepository userRepository;
    private final RateService rateService;

    @PostMapping("/reviews")
    public ResponseEntity<?> enrollReview(@RequestBody CreateReviewRequest request) {
        // TODO: AccessToken 에서 UserID 빼오는 코드 작성
        Long userId = 1L;

        User user = userRepository.findById(userId)
                        .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자입니다."));

        reviewService.enrollReview(
                CreateReviewCommand.builder()
                        .course(courseService.getCourseById(request.getCourseId()))
                        .user(user)
                        .content(request.getContent())
                        .createdTime(LocalDateTime.now())
                        .build()
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/reviews/recommendations")
    public ResponseEntity<?> recommendReview(@RequestBody RecommendReviewRequest request) {
        // TODO: AccessToken 에서 UserID 빼오는 코드 작성
        Long userId = 2L;

        reviewService.recommendReview(
                RecommendReviewCommand.builder()
                        .userId(userId)
                        .reviewId(request.getReviewId())
                        .createdTime(LocalDateTime.now())
                        .build()
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/reviews")
    public ResponseEntity<FindReviewsResponse> getReviews(@RequestParam("course_id") Long cid, @RequestParam("sorting") String key) {
        ReviewSortKey sortKey = ReviewSortKey.getInstance(key);
        if (sortKey == null)
            throw new RuntimeException("존재하지 않는 정렬키입니다.");


        List<ReviewDto> reviewDtos = null;
        if (sortKey.equals(ReviewSortKey.TIME))
            reviewDtos = reviewService.findReviewsByCreatedTime(cid);
        else if (sortKey.equals(ReviewSortKey.RECOMMENDATION))
            reviewDtos = reviewService.findReviewsByRecommendation(cid);

        return ResponseEntity.status(HttpStatus.CREATED).body(FindReviewsResponse.of(reviewDtos));
    }

    @DeleteMapping("/reviews/recommendations/{recommendation_id}")
    public ResponseEntity<?> unrecomendReview(@PathVariable Long recommendation_id) {
        // TODO: AccessToken 에서 UserID 빼오는 코드 작성
        Long userId = 2L;

        reviewService.unrecommendReview(
                RecommendationId.of(userId, recommendation_id)
        );
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/rates")
    public ResponseEntity<?> ratingCourse(@RequestBody RatingCourseRequest request) {
        // TODO: AccessToken 에서 UserID 빼오는 코드 작성
        Long userId = 1L;

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("존재하지 않는 사용자입니다."));
        Course course = courseService.getCourseById(request.getCourseId());

        rateService.ratingCourse(user, course, request.getScore());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
