package ggong_ggong.ridingbud.api;

import ggong_ggong.ridingbud.api.res.CourseListResponse;
import ggong_ggong.ridingbud.api.res.TotalCourseListResponse;
import ggong_ggong.ridingbud.application.CourseService;
import ggong_ggong.ridingbud.enums.Level;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    //레벨별로 코스 조회
    @GetMapping()
    public List<CourseListResponse> getTotalCourses(
            @RequestParam(value = "level", defaultValue = "BEGINNER") Level level
    ){
        //TODO auth로 사용자 조회
        return courseService.getTotalCourses(level);
    }

    //사용자가 즐겨찾기 해둔 코스 조회
    @GetMapping("/favorites")
    public List<CourseListResponse> getFavoriteCourse(Long userId){
//        Long userId = 1L;
        //TODO auth로 사용자 조회
        return courseService.getFavoriteCourses(userId);
    }

    //별점 순으로 정렬된 코스 목록 반환
//    @GetMapping()
//    public List<TotalCourseListResponse> getCoursesByRate(){
//        return courseService.getCourseSortByRate();
//    }

}
