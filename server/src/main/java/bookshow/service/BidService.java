package bookshow.service;

import bookshow.model.Bid;
import bookshow.model.props.UsedProp;
import bookshow.model.users.RegisteredUser;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface BidService {
    List<Bid> findAll();

    List<Bid> findByUsedProp(UsedProp usedProp);

    Bid findByRegisteredUserAndUsedProp(RegisteredUser registeredUser, UsedProp usedProp);

    Bid findOne(Long id);

    Bid save(Bid bid);

    Bid findByPrice(Integer price);

    Bid findByRegisteredUser(RegisteredUser registeredUser);

    void delete(Long id);
}
