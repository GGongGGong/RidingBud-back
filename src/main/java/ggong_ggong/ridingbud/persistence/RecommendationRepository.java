package ggong_ggong.ridingbud.persistence;

import ggong_ggong.ridingbud.domain.Recommendation;
import ggong_ggong.ridingbud.domain.RecommendationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, RecommendationId> {
}
