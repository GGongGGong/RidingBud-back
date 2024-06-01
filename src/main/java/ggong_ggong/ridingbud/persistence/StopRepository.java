package ggong_ggong.ridingbud.persistence;

import ggong_ggong.ridingbud.domain.Course;
import ggong_ggong.ridingbud.domain.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface StopRepository extends JpaRepository<Stop,Long> {
    ArrayList<Stop> findAllByCourse(Course course);
}
