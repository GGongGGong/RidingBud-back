package ggong_ggong.ridingbud.persistence;

import ggong_ggong.ridingbud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
}
