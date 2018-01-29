package bookshow.service;

import bookshow.model.props.PropUsed;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface PropUsedService {
    List<PropUsed> findAll();

    PropUsed findOne(Long id);

    PropUsed save(PropUsed propUsed);

    void delete(Long id);
}
