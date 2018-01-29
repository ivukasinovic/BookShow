package bookshow.controller;

import bookshow.model.Bid;
import bookshow.service.BidService;
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
    private BidService BidService;

    @RequestMapping(
            value = "/getBids",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Bid>> getBids() {
        List<Bid> bids = BidService.findAll();
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/createBid",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bid> createBid(@RequestBody Bid bid) {
        Bid savedBid = BidService.save(bid);
        return new ResponseEntity<>(savedBid, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/updateBid",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bid> updateBid(@RequestBody Bid bid) {
        Bid updatedBid = BidService.save(bid);
        return new ResponseEntity<>(updatedBid, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/deleteBid/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bid> deleteBid(@PathVariable("id") Long id) {
        BidService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
