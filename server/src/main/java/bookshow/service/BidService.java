package bookshow.service;

import bookshow.model.Bid;
import bookshow.model.props.UsedProp;
import bookshow.model.users.User;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface BidService {
    List<Bid> findAll();

    List<Bid> findByUsedProp(UsedProp usedProp);

    Bid findByUserAndUsedProp(User user, UsedProp usedProp);

    Bid findOne(Long id);

    Bid save(Bid bid);

    Bid findByPrice(Integer price);

    Bid findByUser(User user);

    void delete(Long id);
}
