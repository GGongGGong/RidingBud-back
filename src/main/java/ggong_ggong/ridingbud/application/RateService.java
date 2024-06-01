package ggong_ggong.ridingbud.application;

import ggong_ggong.ridingbud.domain.Course;
import ggong_ggong.ridingbud.domain.Rate;
import ggong_ggong.ridingbud.domain.User;
import ggong_ggong.ridingbud.persistence.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RateService {

    private final RateRepository rateRepository;

    public void ratingCourse(User user, Course course, Short score) {
        Rate rate = Rate.builder()
                .user(user)
                .course(course)
                .score(score)
                .build();

        rateRepository.save(rate);
    }
}
