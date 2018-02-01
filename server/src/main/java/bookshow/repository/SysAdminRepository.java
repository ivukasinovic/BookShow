package bookshow.repository;

import bookshow.model.users.SysAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface SysAdminRepository extends JpaRepository<SysAdmin,Long> {
    List<SysAdmin> findAll();

    SysAdmin findOne(Long id);

    SysAdmin save(SysAdmin sysAdmin);

    void delete(Long id);
}
