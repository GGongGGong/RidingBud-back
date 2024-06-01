package ggong_ggong.ridingbud.domain;

import ggong_ggong.ridingbud.enums.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@NoArgsConstructor
public class Stop {
    @Id
    private Long stopId;

    @JoinColumn(name = "course_id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Course course;

    @Enumerated(EnumType.STRING)
    private Type type;

    private String stopName;
    private Float x;
    private Float y;


}
