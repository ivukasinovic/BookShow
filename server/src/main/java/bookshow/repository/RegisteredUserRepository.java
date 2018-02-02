package bookshow.repository;

import bookshow.model.users.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 28-Jan-18
 */
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {
    RegisteredUser findOne(Long id);

    RegisteredUser findByUsername(String username);

    List<RegisteredUser> findAll();

    RegisteredUser save(RegisteredUser regUser);

    void delete(Long id);
}
