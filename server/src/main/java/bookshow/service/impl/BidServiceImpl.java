package bookshow.service.impl;

import bookshow.domain.Bid;
import bookshow.domain.props.UsedProp;
import bookshow.domain.users.User;
import bookshow.repository.BidRepository;
import bookshow.service.BidService;
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
    public List<Bid> findByUsedPropOrderByPriceDesc(UsedProp usedProp) {
        return bidRepository.findByUsedPropOrderByPriceDesc(usedProp);
    }

    @Override
    public List<Bid> findByUsedProp(UsedProp usedProp) {
        return bidRepository.findByUsedProp(usedProp);
    }

    @Override
    public Bid findByUserAndUsedProp(User user, UsedProp usedProp) {
        return bidRepository.findByUserAndUsedProp(user, usedProp);
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
    public Bid findByUser(User user) {
        return bidRepository.findByUser(user);
    }

    @Override
    public void delete(Long id) {
        bidRepository.delete(id);
    }
}
