package bookshow.repository;

import bookshow.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 01-Feb-18
 */
public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findAll();

    Show findOne(Long id);

    Show save(Show show);

    void delete(Long id);

}
