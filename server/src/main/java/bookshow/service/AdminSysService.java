package bookshow.service;

import bookshow.model.users.AdminSys;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface AdminSysService {
    List<AdminSys> findAll();

    AdminSys findOne(Long id);

    AdminSys save(AdminSys adminSys);

    void delete(Long id);
}
