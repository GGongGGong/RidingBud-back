package ggong_ggong.ridingbud.application;

import ggong_ggong.ridingbud.api.res.CourseListResponse;
import ggong_ggong.ridingbud.api.StopDto;
import ggong_ggong.ridingbud.domain.Course;
import ggong_ggong.ridingbud.domain.User;
import ggong_ggong.ridingbud.enums.Level;
import ggong_ggong.ridingbud.persistence.CourseRepository;
import ggong_ggong.ridingbud.persistence.FavoriteCourseRespository;
import ggong_ggong.ridingbud.persistence.StopRepository;
import ggong_ggong.ridingbud.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final StopRepository stopRepository;
    private final FavoriteCourseRespository favoriteCourseRespository;
    private final UserRepository userRepository;

    //코스 레벨별로 조회
    public List<CourseListResponse> getTotalCourses(Level level){
        //List<StopDto> 반환
        return courseRepository.findCoursesByLevel(level).stream()
                .map(c -> new CourseListResponse(c,getStopsByCourse(c))).toList();
    }

    //사용자가 즐겨찾기한 코스 조회
    public List<CourseListResponse> getFavoriteCourses(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("유효하지 않은 멤버 입니다."));
        return favoriteCourseRespository.findAllByUser(user).stream()
                .map(c -> new CourseListResponse(c.getCourse(), getStopsByCourse(c.getCourse()))).toList();

    }

    private List<StopDto> getStopsByCourse(Course course){
        return stopRepository.findAllByCourse(course).stream().map(StopDto::new).collect(Collectors.toList());
    }

    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 코스입니다."));
    }

}


