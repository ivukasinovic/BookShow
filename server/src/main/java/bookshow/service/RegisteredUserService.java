package bookshow.service;

import bookshow.model.users.RegisteredUser;

import java.util.List;

/**
 * Created by Ivan V. on 28-Jan-18
 */
public interface RegisteredUserService {
    RegisteredUser findOne(Long id);

    RegisteredUser findByUsername(String username);

    List<RegisteredUser> findAll();

    RegisteredUser save(RegisteredUser regUser);

    void delete(Long id);
}
