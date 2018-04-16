package bookshow.service;

import bookshow.domain.props.NewProp;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@Service
public interface NewPropService {

    List<NewProp> findAll();

    List<NewProp> findByUserIsNull();

    NewProp findOne(Long id);

    NewProp save(NewProp newProp);

    void delete(Long id);
}
