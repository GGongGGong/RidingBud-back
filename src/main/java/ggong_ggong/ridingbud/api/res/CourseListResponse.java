package ggong_ggong.ridingbud.api.res;

import ggong_ggong.ridingbud.domain.Course;
import ggong_ggong.ridingbud.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CourseListResponse {
    private Long courseId;
    private String courseName;
    private Level level;
    private Float distance;
    private String estimatedTime;
    private List<StopDto> stops;

    public CourseListResponse(Course course, List<StopDto> stopList){
        this.courseId = course.getCourseId();
        this.courseName = course.getCourseName();
        this.level = course.getLevel();
        this.distance = course.getDistance();
        this.estimatedTime = course.getEstimatedTime();
        this.stops = stopList;
    }
}
