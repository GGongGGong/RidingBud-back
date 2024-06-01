package ggong_ggong.ridingbud.api;

import ggong_ggong.ridingbud.domain.Stop;
import ggong_ggong.ridingbud.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StopDto {
    private Long stopId;
    private Type type;
    private String stopName;
    private Float x;
    private Float y;

    public StopDto(Stop stop){
        this.stopId = stop.getStopId();
        this.type = stop.getType();
        this.stopName = getStopName();
        this.x = getX();
        this.y = getY();
    }
}
