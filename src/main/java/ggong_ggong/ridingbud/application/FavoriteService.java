package ggong_ggong.ridingbud.application;

import ggong_ggong.ridingbud.domain.Course;
import ggong_ggong.ridingbud.domain.FavoriteCourse;
import ggong_ggong.ridingbud.domain.User;
import ggong_ggong.ridingbud.persistence.CourseRepository;
import ggong_ggong.ridingbud.persistence.FavoriteCourseRespository;
import ggong_ggong.ridingbud.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoriteService {
    private final UserRepository userRepository;
    private final FavoriteCourseRespository favoriteCourseRespository;
    private final CourseRepository courseRepository;

    public void postFavorite(Long userId,Long courseId){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 멤버 입니다."));
        Course course = courseRepository.findById(courseId).orElseThrow(() ->  new IllegalArgumentException("잘못된 요청입니다. (존재하지 않는 코스 ID)"));
        favoriteCourseRespository.save(new FavoriteCourse(course,user));
    }

    public void deleteFavorite(Long userId,Long courseId){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 멤버 입니다."));
        Course course = courseRepository.findById(courseId).orElseThrow(() ->  new IllegalArgumentException("잘못된 요청입니다. (존재하지 않는 코스 ID)"));
        FavoriteCourse favoriteCourse = favoriteCourseRespository.findByCourseAndUser(course,user).orElseThrow(() ->  new IllegalArgumentException("잘못된 요청입니다. (존재하지 않는 즐겨 찾기 코스 ID)"));
        favoriteCourseRespository.delete(favoriteCourse);
    }
}
