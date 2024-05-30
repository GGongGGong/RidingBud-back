package ggong_ggong.ridingbud.domain;


import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class RecommendationId implements Serializable {

    private Long userId;

    private Long reviewId;

    public static RecommendationId of(Long userId, Long reviewId) {
        return new RecommendationId(userId, reviewId);
    }
}
