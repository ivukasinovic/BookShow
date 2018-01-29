package bookshow.service;

import bookshow.model.props.PropNew;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface PropNewService {

    List<PropNew> findAll();

    PropNew findOne(Long id);

    PropNew save(PropNew propNew);

    void delete(Long id);
}
