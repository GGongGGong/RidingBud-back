package ggong_ggong.ridingbud.persistence;

import ggong_ggong.ridingbud.domain.Course;
import ggong_ggong.ridingbud.domain.FavoriteCourse;
import ggong_ggong.ridingbud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteCourseRespository extends JpaRepository<FavoriteCourse,Long> {

    List<FavoriteCourse> findAllByUser(User user);
}
