package ggong_ggong.ridingbud.api.res;

import ggong_ggong.ridingbud.domain.PumpStation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE) @Builder
@Getter
public class PumpStationDto {

    private Long pumpStationId;
    private Float x;
    private Float y;
    private String stationName;
    private String address;

    public static PumpStationDto from(PumpStation pumpStation) {
        return PumpStationDto.builder()
                .pumpStationId(pumpStation.getPumpStationId())
                .x(pumpStation.getX())
                .y(pumpStation.getY())
                .stationName(pumpStation.getStationName())
                .address(pumpStation.getAddress())
                .build();
    }
}
