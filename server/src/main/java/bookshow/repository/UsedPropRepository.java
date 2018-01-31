package bookshow.repository;

import bookshow.model.props.UsedProp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface UsedPropRepository extends JpaRepository<UsedProp,Long> {
    List<UsedProp> findAll();

    UsedProp findOne(Long id);

    UsedProp save(UsedProp usedProp);

    void delete(Long id);
}
