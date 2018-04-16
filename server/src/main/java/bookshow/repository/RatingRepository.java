package bookshow.repository;

import bookshow.domain.users.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ivan V. on 17-Apr-18
 */
public interface RatingRepository extends JpaRepository<Rating, Long> {
}
