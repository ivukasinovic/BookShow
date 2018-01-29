package bookshow.repository;

import bookshow.model.props.PropUsed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface PropUsedRepository extends JpaRepository<PropUsed,Long> {
    List<PropUsed> findAll();

    PropUsed findOne(Long id);

    PropUsed save(PropUsed propUsed);

    void delete(Long id);
}
