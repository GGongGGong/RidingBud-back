package ggong_ggong.ridingbud.application;

import ggong_ggong.ridingbud.domain.BicycleRental;
import ggong_ggong.ridingbud.persistence.BicycleRentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityService {
    private BicycleRentalRepository bicycleRentalRepository;

    public List<BicycleRental> getBicycleRentals() {
        return bicycleRentalRepository.findAll();
    }
}
