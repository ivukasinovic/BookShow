package bookshow.repository;

import bookshow.model.users.AdminSys;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface AdminSysRepository extends JpaRepository<AdminSys,Long> {
    List<AdminSys> findAll();

    AdminSys findOne(Long id);

    AdminSys save(AdminSys adminSys);

    void delete(Long id);
}
