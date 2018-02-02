package bookshow.service;

import bookshow.model.Bid;
import bookshow.model.props.UsedProp;
import bookshow.model.users.RegisteredUser;
import bookshow.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@Service
public class BidServiceImpl implements BidService {
    @Autowired
    private BidRepository bidRepository;

    @Override
    public List<Bid> findAll() {
        return bidRepository.findAll();
    }

    @Override
    public List<Bid> findByUsedProp(UsedProp usedProp) {
        return bidRepository.findByUsedProp(usedProp);
    }

    @Override
    public Bid findByRegisteredUserAndUsedProp(RegisteredUser registeredUser, UsedProp usedProp) {
        return bidRepository.findByRegisteredUserAndUsedProp(registeredUser,usedProp);
    }

    @Override
    public Bid findOne(Long id) {
        return bidRepository.findOne(id);
    }

    @Override
    public Bid save(Bid bid) {
        return bidRepository.save(bid);
    }

    @Override
    public Bid findByPrice(Integer price) {
        return bidRepository.findByPrice(price);
    }

    @Override
    public Bid findByRegisteredUser(RegisteredUser registeredUser) {
        return bidRepository.findByRegisteredUser(registeredUser);
    }

    @Override
    public void delete(Long id) {
        bidRepository.delete(id);
    }
}
