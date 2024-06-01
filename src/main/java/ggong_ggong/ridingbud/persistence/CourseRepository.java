package ggong_ggong.ridingbud.persistence;

import ggong_ggong.ridingbud.domain.Course;
import ggong_ggong.ridingbud.enums.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCoursesByLevel(Level level);
}
