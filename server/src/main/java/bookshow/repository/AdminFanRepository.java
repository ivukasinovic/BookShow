package bookshow.repository;

import bookshow.model.users.AdminFan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 28-Jan-18
 */
public interface AdminFanRepository extends JpaRepository<AdminFan, Long> {
    AdminFan findOne(Long id);

    List<AdminFan> findAll();

    AdminFan save(AdminFan adminFan);

    void delete(Long id);


}
