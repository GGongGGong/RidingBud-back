package ggong_ggong.ridingbud.application;

import ggong_ggong.ridingbud.domain.Recommendation;
import ggong_ggong.ridingbud.domain.Review;
import ggong_ggong.ridingbud.persistence.RecommendationRepository;
import ggong_ggong.ridingbud.persistence.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RecommendationRepository recommendationRepository;

    public void enrollReview(CreateReviewCommand command) {
        Review review = Review.from(command);

        reviewRepository.save(review);
    }

    public void recommendReview(RecommendReviewCommand command) {
        Recommendation recommendation = Recommendation.from(command);

        recommendationRepository.save(recommendation);
    }
}
