package bookshow.repository;

import bookshow.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ivan V.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
