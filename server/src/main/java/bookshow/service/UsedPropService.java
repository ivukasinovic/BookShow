package bookshow.service;

import bookshow.model.props.UsedProp;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface UsedPropService {
    List<UsedProp> findAll();

    UsedProp findOne(Long id);

    UsedProp save(UsedProp usedProp);

    void delete(Long id);
}