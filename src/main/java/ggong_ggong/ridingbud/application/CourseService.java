package ggong_ggong.ridingbud.application;

import ggong_ggong.ridingbud.api.res.CourseListResponse;
import ggong_ggong.ridingbud.api.res.StopDto;
import ggong_ggong.ridingbud.domain.Course;
import ggong_ggong.ridingbud.enums.Level;
import ggong_ggong.ridingbud.persistence.CourseRepository;
import ggong_ggong.ridingbud.persistence.StopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final StopRepository stopRepository;

    //코스 레벨별로 조회
    public List<CourseListResponse> getTotalCourses(Level level){
        //List<StopDto> 반환
        return courseRepository.findCoursesByLevel(level).stream()
                .map(c -> new CourseListResponse(c,getStopsByCourse(c))).toList();
    }

    public List<StopDto> getStopsByCourse(Course course){
        return stopRepository.findAllByCourse(course).stream().map(StopDto::new).collect(Collectors.toList());
    }

}


