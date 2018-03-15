package bookshow.repository;

import bookshow.model.props.NewProp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface NewPropRepository extends JpaRepository<NewProp, Long> {
    List<NewProp> findAll();

    List<NewProp> findByUserIsNull();

    NewProp findOne(Long id);

    NewProp save(NewProp newProp);

    void delete(Long id);


}
