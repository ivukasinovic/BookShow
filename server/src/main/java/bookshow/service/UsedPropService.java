package bookshow.service;

import bookshow.model.props.UsedProp;
import bookshow.model.props.UsedPropStatus;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface UsedPropService {
    List<UsedProp> findAll();

    UsedProp findOne(Long id);

    List<UsedProp> findByFanAdminIsNotNull();

    List<UsedProp> findByActiveUntilGreaterThanAndStatusEquals(java.util.Date date, UsedPropStatus usedPropStatus);

    UsedProp save(UsedProp usedProp);

    void delete(Long id);
}
