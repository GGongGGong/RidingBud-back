package ggong_ggong.ridingbud.application;

import ggong_ggong.ridingbud.domain.BicycleRental;
import ggong_ggong.ridingbud.domain.PumpStation;
import ggong_ggong.ridingbud.persistence.BicycleRentalRepository;
import ggong_ggong.ridingbud.persistence.PumpStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityService {
    private final BicycleRentalRepository bicycleRentalRepository;
    private final PumpStationRepository pumpStationRepository;

    public List<BicycleRental> getBicycleRentals() {
        return bicycleRentalRepository.findAll();
    }

    public List<PumpStation> getPumpStations() {
        return pumpStationRepository.findAll();
    }
}
