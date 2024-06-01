package ggong_ggong.ridingbud.persistence;

import ggong_ggong.ridingbud.domain.Course;
import ggong_ggong.ridingbud.domain.FavoriteCourse;
import ggong_ggong.ridingbud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FavoriteCourseRespository extends JpaRepository<FavoriteCourse,Long> {

    List<FavoriteCourse> findAllByUser(User user);

    Optional<FavoriteCourse> findByCourseAndUser(Course course, User user);
}
