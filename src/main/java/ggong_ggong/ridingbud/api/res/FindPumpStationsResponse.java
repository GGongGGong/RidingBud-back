package ggong_ggong.ridingbud.api.res;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class FindPumpStationsResponse {
    List<PumpStationDto> pumps;

    public static FindPumpStationsResponse of(List<PumpStationDto> pumpStationDtos) {
        return new FindPumpStationsResponse(pumpStationDtos);
    }
}
