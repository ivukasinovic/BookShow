package bookshow.service;

import bookshow.model.users.SysAdmin;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface SysAdminService {
    List<SysAdmin> findAll();

    SysAdmin findOne(Long id);

    SysAdmin save(SysAdmin sysAdmin);

    void delete(Long id);
}
