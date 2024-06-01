package ggong_ggong.ridingbud.persistence;

import ggong_ggong.ridingbud.domain.Course;
import ggong_ggong.ridingbud.domain.FavoriteCourse;
import ggong_ggong.ridingbud.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteCourseRespository extends JpaRepository<FavoriteCourse,Long> {

    List<FavoriteCourse> findAllByMember(Member member);

    Optional<FavoriteCourse> findByCourseAndMember(Course course, Member member);
}
