package ggong_ggong.ridingbud.api.res;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class FindReviewsResponse {

    List<ReviewDto> reviews;

    public static FindReviewsResponse of(List<ReviewDto> reviews) {
        return new FindReviewsResponse(reviews);
    }
}
