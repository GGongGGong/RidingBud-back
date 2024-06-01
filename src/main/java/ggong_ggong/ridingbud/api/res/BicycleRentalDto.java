package ggong_ggong.ridingbud.api.res;

import ggong_ggong.ridingbud.domain.BicycleRental;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE) @Builder
@Getter
public class BicycleRentalDto {
    private Long bicycleRentalId;
    private Float x;
    private Float y;
    private String stationName;
    private Short totalCount;
    private Short remainder;
    private String operationTime;
    private String detailLocation;
    private String call;

    public static BicycleRentalDto from(BicycleRental bicycleRental) {
        return BicycleRentalDto.builder()
                .bicycleRentalId(bicycleRental.getBicycleRentalId())
                .x(bicycleRental.getX())
                .y(bicycleRental.getY())
                .stationName(bicycleRental.getStationName())
                .totalCount(bicycleRental.getTotalCount())
                .remainder(bicycleRental.getRemainder())
                .operationTime(bicycleRental.getOperationTime())
                .detailLocation(bicycleRental.getDetailLocation())
                .call(bicycleRental.getContact())
                .build();
    }
}
