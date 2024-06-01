package ggong_ggong.ridingbud.persistence;

import ggong_ggong.ridingbud.domain.BicycleRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicycleRentalRepository extends JpaRepository<BicycleRental, Long> {
}
