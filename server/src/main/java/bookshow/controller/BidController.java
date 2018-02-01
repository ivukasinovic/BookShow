package bookshow.controller;

import bookshow.model.Bid;
import bookshow.model.props.UsedProp;
import bookshow.model.users.RegisteredUser;
import bookshow.service.BidService;
import bookshow.service.RegisteredUserService;
import bookshow.service.UsedPropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@RestController
public class BidController {
    @Autowired
    private BidService bidService;
    @Autowired
    private RegisteredUserService registeredUserService;
    @Autowired
    private UsedPropService usedPropService;

    @RequestMapping(
            value = "/bids",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Bid>> getBids() {
        List<Bid> bids = bidService.findAll();
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }
    @RequestMapping(
            value = "/bids/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bid> getBid(@PathVariable("id") Long id) {
        Bid bid = bidService.findOne(id);
        return new ResponseEntity<>(bid, HttpStatus.OK);
    }
    @RequestMapping(
            value = "/bids/usedProp/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Bid>> getBidByUsedProp(@PathVariable("id") Long id) {
        UsedProp usedProp = usedPropService.findOne(id);
        List<Bid> bids = bidService.findByUsedProp(usedProp);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/bids/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bid> createBid(@RequestBody Bid bid,@PathVariable("id") Long id) {
        //ceka se logovanje(hardkod)
        RegisteredUser registeredUser = registeredUserService.findOne(6L);
        Bid old = bidService.findByRegisteredUser(registeredUser);
        if(old!=null)
            bid.setId(old.getId());
        bid.setDateCreated(new java.util.Date());
        bid.setRegisteredUser(registeredUser);
        bid.setUsedProp(usedPropService.findOne(id));
        Bid savedBid = bidService.save(bid);
        return new ResponseEntity<>(savedBid, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/bids",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bid> updateBid(@RequestBody Bid bid) {
        Bid updatedBid = bidService.save(bid);
        return new ResponseEntity<>(updatedBid, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/bids/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bid> deleteBid(@PathVariable("id") Long id) {
        bidService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
