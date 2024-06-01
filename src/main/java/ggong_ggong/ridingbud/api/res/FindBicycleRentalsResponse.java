package ggong_ggong.ridingbud.api.res;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class FindBicycleRentalsResponse {

    private List<BicycleRentalDto> bicycleRentals;

    public static FindBicycleRentalsResponse of(List<BicycleRentalDto> bicycleRentalDtos) {
        return new FindBicycleRentalsResponse(bicycleRentalDtos);
    }
}
