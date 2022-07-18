package Youth.SW.repository;

import Youth.SW.entity.AppCom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppComRepository extends JpaRepository<AppCom, Long> {

    @Query("select c from AppCom as c where c.rid = :rid")
    List<AppCom> findCommentByRid(@Param("rid") String rid);
}
