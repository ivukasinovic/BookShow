package bookshow.service;

import bookshow.model.users.FanAdmin;

import java.util.List;

/**
 * Created by Ivan V. on 28-Jan-18
 */
public interface FanAdminService {
    FanAdmin findOne(Long id);

    List<FanAdmin> findAll();

    FanAdmin save(FanAdmin fanAdmin);

    FanAdmin update(FanAdmin fanAdmin);

    void delete(Long id);

}
