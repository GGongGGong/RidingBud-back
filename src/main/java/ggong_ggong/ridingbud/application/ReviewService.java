package ggong_ggong.ridingbud.application;

import ggong_ggong.ridingbud.api.res.ReviewDto;
import ggong_ggong.ridingbud.domain.Recommendation;
import ggong_ggong.ridingbud.domain.Review;
import ggong_ggong.ridingbud.persistence.RecommendationRepository;
import ggong_ggong.ridingbud.persistence.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RecommendationRepository recommendationRepository;

    public void enrollReview(CreateReviewCommand command) {
        Review review = Review.from(command);

        reviewRepository.save(review);
    }

    public List<ReviewDto> findReviewsByCreatedTime(Long courseId) {

        return reviewRepository.findAllByCourseIdOrderByCreatedTimeDesc(courseId)
                .stream()
                .map(ReviewDto::of)
                .collect(Collectors.toList());
    }

    public List<ReviewDto> findReviewsByRecommendation(Long courseId) {

        return reviewRepository.findAllByCourseIdOrderByRecommendation(courseId)
                .stream()
                .map(ReviewDto::of)
                .collect(Collectors.toList());
    }

    public void recommendReview(RecommendReviewCommand command) {
        Optional<Review> targetReview = reviewRepository.findById(command.getReviewId());
        if (targetReview.isEmpty())
            throw new RuntimeException("존재하지 않는 리뷰입니다.");
        if (targetReview.get().getUserId().equals(command.getUserId()))
            throw new RuntimeException("자신의 리뷰는 추천할 수 없습니다.");

        Recommendation recommendation = Recommendation.from(command);

        recommendationRepository.save(recommendation);
    }
}
