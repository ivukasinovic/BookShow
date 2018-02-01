package bookshow.service;

import bookshow.model.props.NewProp;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface NewPropService {

    List<NewProp> findAll();

    List<NewProp> findByRegisteredUserIsNull();

    NewProp findOne(Long id);

    NewProp save(NewProp newProp);

    void delete(Long id);
}
