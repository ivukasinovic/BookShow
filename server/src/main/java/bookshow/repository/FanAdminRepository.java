package bookshow.repository;

import bookshow.model.users.FanAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 28-Jan-18
 */
public interface FanAdminRepository extends JpaRepository<FanAdmin, Long> {
    FanAdmin findOne(Long id);

    List<FanAdmin> findAll();

    FanAdmin save(FanAdmin fanAdmin);

    void delete(Long id);


}
