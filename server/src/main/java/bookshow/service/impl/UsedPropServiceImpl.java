package bookshow.service.impl;

import bookshow.model.props.UsedProp;
import bookshow.model.props.UsedPropStatus;
import bookshow.repository.UsedPropRepository;
import bookshow.service.UsedPropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@Service
public class UsedPropServiceImpl implements UsedPropService {
    @Autowired
    private UsedPropRepository usedPropRepository;

    @Override
    public List<UsedProp> findAll() {
        return usedPropRepository.findAll();
    }

    @Override
    public UsedProp findOne(Long id) {
        return usedPropRepository.findOne(id);
    }

    @Override
    public List<UsedProp> findByFanAdminIsNotNull() {
        return usedPropRepository.findByFanAdminIsNotNull();
    }

    @Override
    public List<UsedProp> findByActiveUntilGreaterThanAndStatusEquals(Date date, UsedPropStatus usedPropStatus) {
        return usedPropRepository.findByActiveUntilGreaterThanAndStatusEquals(date, usedPropStatus);
    }


    @Override
    public UsedProp save(UsedProp usedProp) {
        return usedPropRepository.save(usedProp);
    }

    @Override
    public void delete(Long id) {
        usedPropRepository.delete(id);
    }
}
