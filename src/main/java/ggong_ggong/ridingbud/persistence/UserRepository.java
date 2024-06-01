package ggong_ggong.ridingbud.persistence;

import ggong_ggong.ridingbud.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Member,Long> {
    Member findUserByEmail(String email);
}
