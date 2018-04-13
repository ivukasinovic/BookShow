package bookshow.service.impl;

import bookshow.domain.Bid;
import bookshow.domain.props.UsedProp;
import bookshow.domain.props.UsedPropStatus;
import bookshow.domain.users.User;
import bookshow.repository.UsedPropRepository;
import bookshow.service.BidService;
import bookshow.service.UsedPropService;
import bookshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private BidService bidService;

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
    public List<UsedProp> findByActiveUntilGreaterThanAndStatusEqualsAndAcceptedBidNull(Date date, UsedPropStatus usedPropStatus) {
        return usedPropRepository.findByActiveUntilGreaterThanAndStatusEqualsAndAcceptedBidNull(date, usedPropStatus);
    }

    @Override
    public List<UsedProp> findByActiveUntilGreaterThanAndAcceptedBidNullAndStatusNot(Date date, UsedPropStatus usedPropStatus) {
        return usedPropRepository.findByActiveUntilGreaterThanAndAcceptedBidNullAndStatusNot(date, usedPropStatus);
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

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public UsedProp approveDecline(Long usedPropId, String type, User adminFan) throws Exception {
        UsedProp usedProp = usedPropRepository.findOne(usedPropId);
        if(type.equals("approve")){
            usedProp.setStatus(UsedPropStatus.APPROVED);
        }else if (type.equals("decline")) {
            usedProp.setStatus(UsedPropStatus.DECLINED);
        }
        usedProp.setFanAdmin(adminFan);
        UsedProp savedUsedProp = save(usedProp);
        return savedUsedProp;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public boolean acceptBid(Long usedPropId, Long acceptedBidId) {
        UsedProp usedProp = findOne(usedPropId);
        Bid bid = bidService.findOne(acceptedBidId);
        usedProp.setAcceptedBid(bid.getId());
        usedProp = save(usedProp);
        if(usedProp == null){
            return false;
        }
        return  true;
    }

}
