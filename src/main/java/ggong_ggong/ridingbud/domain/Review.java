package ggong_ggong.ridingbud.domain;

import ggong_ggong.ridingbud.application.CreateReviewCommand;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE) @Builder
@Getter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @JoinColumn(name = "course_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Course course;
    // TODO: ORM
    private Long userId;

    private String content;
    private LocalDateTime createdTime;

    public static Review from(CreateReviewCommand command) {
        return Review.builder()
                .course(command.getCourse())
                .userId(command.getUserId())
                .content(command.getContent())
                .createdTime(command.getCreatedTime())
                .build();
    }
}
