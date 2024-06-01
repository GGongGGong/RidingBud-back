package ggong_ggong.ridingbud.persistence;

import ggong_ggong.ridingbud.domain.PumpStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PumpStationRepository extends JpaRepository<PumpStation, Long> {
}
