package ggong_ggong.ridingbud.api;

import ggong_ggong.ridingbud.api.res.BicycleRentalDto;
import ggong_ggong.ridingbud.api.res.FindBicycleRentalsResponse;
import ggong_ggong.ridingbud.api.res.FindPumpStationsResponse;
import ggong_ggong.ridingbud.api.res.PumpStationDto;
import ggong_ggong.ridingbud.application.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/facilities")
public class FacilityController {
    private final FacilityService facilityService;

    @GetMapping("bicycles")
    public ResponseEntity<FindBicycleRentalsResponse> findBicycleRentals() {

        List<BicycleRentalDto> result = facilityService.getBicycleRentals()
                .stream()
                .map(BicycleRentalDto::from)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(
                FindBicycleRentalsResponse.of(result)
        );
    }

    @GetMapping("/pumps")
    public ResponseEntity<FindPumpStationsResponse> findPumpStations() {

        List<PumpStationDto> result = facilityService.getPumpStations()
                .stream()
                .map(PumpStationDto::from)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(
                FindPumpStationsResponse.of(result)
        );
    }
}
