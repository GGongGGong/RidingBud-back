package ggong_ggong.ridingbud.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE) @Builder
@Getter
public class PumpStation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pumpStationId;

    private Float x;
    private Float y;
    private String stationName;
    private String address;
}
