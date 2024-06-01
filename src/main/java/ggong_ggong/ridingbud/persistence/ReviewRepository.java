package ggong_ggong.ridingbud.persistence;

import ggong_ggong.ridingbud.domain.Review;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = """
        select rev.*, COALESCE(rec.cnt, 0) as cnt
        from Review rev left outer join (select review_id, count(*) as cnt from recommendation group by review_id) as rec
        on rev.review_id = rec.review_id
        where course_id = :cid
        order by rev.created_time""",
        nativeQuery = true)
    List<Tuple> findAllByCourseIdOrderByCreatedTimeDesc(@Param("cid") Long courseId);

    @Query(value = """
        select rev.*, COALESCE(rec.cnt, 0) as cnt
        from Review rev left outer join (select review_id, count(*) as cnt from recommendation group by review_id) as rec
        on rev.review_id = rec.review_id
        where course_id = :cid
        order by rec.cnt""",
        nativeQuery = true)
    List<Tuple> findAllByCourseIdOrderByRecommendation(@Param("cid") Long courseId);
}
