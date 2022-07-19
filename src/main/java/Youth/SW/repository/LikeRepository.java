package Youth.SW.repository;

import Youth.SW.entity.AppInfo;
import Youth.SW.entity.Likes;
import Youth.SW.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {

    Optional<Likes> findByUserInfoAndAppInfo(UserInfo user, AppInfo app);

    List<Likes> findByAppInfo(AppInfo app);
}
