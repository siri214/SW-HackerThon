package Youth.SW.repository;

import Youth.SW.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByUserId(String userId);

    Optional<UserInfo> findById(Long id);
}

