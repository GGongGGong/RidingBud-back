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
public class BicycleRental {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bicycleRentalId;

    private Float x;
    private Float y;
    private String stationName;
    private Short totalCount;
    private Short remainder;
    private String operationTime;
    private String detailLocation;
    private String call;
}
