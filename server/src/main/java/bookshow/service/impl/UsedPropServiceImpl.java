package bookshow.service.impl;

import bookshow.domain.Bid;
import bookshow.domain.props.UsedProp;
import bookshow.domain.props.UsedPropStatus;
import bookshow.domain.users.Role;
import bookshow.domain.users.User;
import bookshow.repository.UsedPropRepository;
import bookshow.service.BidService;
import bookshow.service.UsedPropService;
import bookshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@Service
@Transactional(readOnly =  true)
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
    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
    public UsedProp save(UsedProp usedProp) {
        return usedPropRepository.save(usedProp);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        usedPropRepository.delete(id);
    }

    @Override
    public List<UsedProp> findByUsername(String username) {
        User user = userService.findByUsername(username);
        return usedPropRepository.findByUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public UsedProp createUsedProp(String username, UsedProp usedProp){
        User user = userService.findByUsername(username);
        if(user.getRole() == Role.ADMINFAN){
            usedProp.setStatus(UsedPropStatus.APPROVED);
            usedProp.setFanAdmin(user);
        }
        else{
            usedProp.setStatus(UsedPropStatus.WAITING);
        }
        usedProp.setUser(userService.findByUsername(username));
        usedProp.setDateCreated(new java.util.Date());
        usedProp.setBids(new ArrayList<Bid>());
        return save(usedProp);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public UsedProp approveDecline(Long usedPropId, String type, User adminFan) {
        UsedProp usedProp = usedPropRepository.findOne(usedPropId);
        checkApprovedUsedProp(usedProp);
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
    public boolean acceptBid(String username, Long usedPropId, Long acceptedBidId) {
        User user = userService.findByUsername(username);
        UsedProp usedProp = findOne(usedPropId);
        checkAcceptedBid(usedProp);
        if(usedProp.getUser() != user){
            return false;
        }
        Bid bid = bidService.findOne(acceptedBidId);
        usedProp.setAcceptedBid(bid.getId());
        usedProp = save(usedProp);
        if(usedProp == null){
            return false;
        }
        return  true;
    }
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public void checkAcceptedBid(UsedProp usedProp) throws TransactionException {
        if(usedProp.getAcceptedBid() != null){
            throw new org.hibernate.TransactionException("Oglas je vec odobren");
        }
    }
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public void checkApprovedUsedProp(UsedProp usedProp) throws TransactionException {
        if((usedProp.getStatus().equals(UsedPropStatus.APPROVED) || (usedProp.getStatus().equals(UsedPropStatus.DECLINED)))){
            throw new org.hibernate.TransactionException("Oglas je vec revidiran od strane drugog administratora fan zone");
        }
    }

}
