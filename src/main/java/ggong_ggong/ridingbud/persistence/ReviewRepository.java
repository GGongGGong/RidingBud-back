package ggong_ggong.ridingbud.persistence;

import ggong_ggong.ridingbud.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
