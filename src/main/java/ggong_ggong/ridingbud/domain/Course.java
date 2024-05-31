package ggong_ggong.ridingbud.domain;

import ggong_ggong.ridingbud.enums.Level;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Course {
    @Id
    private Long courseId;
    private String courseName;
    @Enumerated(EnumType.STRING)
    private Level level;
    private Float distance;
    private String estimatedTime;
}
