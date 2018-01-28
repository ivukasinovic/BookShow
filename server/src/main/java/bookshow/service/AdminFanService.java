package bookshow.service;

import bookshow.model.users.AdminFan;

import java.util.List;

/**
 * Created by Ivan V. on 28-Jan-18
 */
public interface AdminFanService {
    AdminFan findOne(Long id);

    List<AdminFan> findAll();

    AdminFan save(AdminFan adminFan);

    AdminFan update(AdminFan adminFan);

    void delete(Long id);

}
