package Youth.SW.repository;

import Youth.SW.entity.AppInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppInfoRepository extends JpaRepository<AppInfo, Long> {

    @Query("select a from AppInfo as a where a.job = :job")
    List<AppInfo> findByJob(@Param("job") String job);

    AppInfo findByAppURL(String appURL);
}
