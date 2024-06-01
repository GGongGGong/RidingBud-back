package ggong_ggong.ridingbud.api;

import ggong_ggong.ridingbud.api.res.CourseListResponse;
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
        return courseService.getTotalCourses(level);
    }
}
