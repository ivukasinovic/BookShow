package bookshow.repository;

import bookshow.model.props.PropNew;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface PropNewRepository extends JpaRepository<PropNew,Long> {
    List<PropNew> findAll();

    PropNew findOne(Long id);

    PropNew save(PropNew propNew);

    void delete(Long id);



}
