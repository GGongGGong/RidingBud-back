package ggong_ggong.ridingbud.persistence;

import ggong_ggong.ridingbud.domain.Course;
import ggong_ggong.ridingbud.domain.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RateRepository extends JpaRepository<Rate, Long> {

}
