package ggong_ggong.ridingbud.api.res;

import ggong_ggong.ridingbud.api.res.StopDto;
import ggong_ggong.ridingbud.domain.Course;
import ggong_ggong.ridingbud.domain.Rate;
import ggong_ggong.ridingbud.enums.Level;
import lombok.Getter;

import java.util.List;

@Getter
public class TotalCourseListResponse {
    private Long courseId;
    private String courseName;
    private Level level;
    private Float distance;
    private String estimatedTime;
    private List<StopDto> stops;
    private Short score;

    public TotalCourseListResponse(Course course, List<StopDto> stopList, Rate rate){
        this.courseId = course.getCourseId();
        this.courseName = course.getCourseName();
        this.level = course.getLevel();
        this.distance = course.getDistance();
        this.estimatedTime = course.getEstimatedTime();
        this.stops = stopList;
//        this.score = course.;
    }
}
