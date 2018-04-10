package bookshow.service.impl;

import bookshow.domain.Bid;
import bookshow.domain.props.UsedProp;
import bookshow.domain.props.UsedPropStatus;
import bookshow.domain.users.User;
import bookshow.repository.UsedPropRepository;
import bookshow.service.UsedPropService;
import bookshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@Service
public class UsedPropServiceImpl implements UsedPropService {
    @Autowired
    private UsedPropRepository usedPropRepository;
    @Autowired
    private UserService userService;

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

    @Override
    public List<UsedProp> findByUsername(String username) {
        User user = userService.findByUsername(username);
        return usedPropRepository.findByUser(user);
    }

    @Override
    public UsedProp createUsedProp(String username, UsedProp usedProp){
        usedProp.setStatus(UsedPropStatus.WAITING);
        usedProp.setUser(userService.findByUsername(username));
        usedProp.setDateCreated(new java.util.Date());
        usedProp.setBids(new ArrayList<Bid>());
        return save(usedProp);
    }
}
