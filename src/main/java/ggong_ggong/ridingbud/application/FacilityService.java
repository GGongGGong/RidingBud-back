package ggong_ggong.ridingbud.application;

import ggong_ggong.ridingbud.domain.BicycleRental;
import ggong_ggong.ridingbud.domain.PumpStation;
import ggong_ggong.ridingbud.persistence.BicycleRentalRepository;
import ggong_ggong.ridingbud.persistence.PumpStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityService {
    private final BicycleRentalRepository bicycleRentalRepository;
    private final PumpStationRepository pumpStationRepository;

    // 1	설화명곡역	0	0	160	없음	없음	운영안함
    public List<BicycleRental> getBicycleRentals() {
        return bicycleRentalRepository.findAll();
    }

    public List<PumpStation> getPumpStations() {
        return pumpStationRepository.findAll();
    }

    public void saveBicycle(BicycleRental bicycleRental) throws IOException {
        bicycleRentalRepository.save(bicycleRental);
    }
}
