package bookshow.service;

import bookshow.model.users.User;

import java.util.List;

/**
 * Created by Ivan V.
 */
public interface UserService {
    List<User> findAll();

    User findOne(Long id);

    User save(User user);

    void delete(Long id);

}
