package bookshow.controller;

import bookshow.domain.Bid;
import bookshow.domain.props.UsedProp;
import bookshow.domain.props.UsedPropStatus;
import bookshow.domain.users.User;
import bookshow.service.UsedPropService;
import bookshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@RestController
@RequestMapping(value = "/used-props")
public class UsedPropController {
    @Autowired
    private UsedPropService usedPropService;
    @Autowired
    private UserService userService;

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsedProp>> getUsedPropsAll() {
        List<UsedProp> usedProps = usedPropService.findAll();
        return new ResponseEntity<>(usedProps, HttpStatus.OK);
    }

    //all validated by admin
    @RequestMapping(
            value = "/check",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsedProp>> getUsedPropsCheck() {
        List<UsedProp> usedProps = usedPropService.findByFanAdminIsNotNull();
        return new ResponseEntity<>(usedProps, HttpStatus.OK);
    }
    //all not expired and approved, and not finished
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsedProp>> getUsedProps() {
        List<UsedProp> usedProps = usedPropService.findByActiveUntilGreaterThanAndStatusEqualsAndAcceptedBidNull(new java.util.Date(), UsedPropStatus.APPROVED);
        return new ResponseEntity<>(usedProps, HttpStatus.OK);
    }
    //all exept finished
    @RequestMapping(
            value = "/not-finished",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsedProp>> getExceptFinished(){
        List<UsedProp> usedProps = usedPropService.findByActiveUntilGreaterThanAndAcceptedBidNullAndStatusNot(new java.util.Date(), UsedPropStatus.DECLINED);
        return new ResponseEntity<>(usedProps, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsedProp> getUsedProp(@PathVariable("id") Long id) {
        UsedProp usedProp = usedPropService.findOne(id);
        return new ResponseEntity<>(usedProp, HttpStatus.OK);
    }
    //used props by user
    @RequestMapping(
            value = "/user",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsedProp>> getUsedPropsByUser(Principal principal){
        List<UsedProp> usedProps = usedPropService.findByUsername(principal.getName());
        return new ResponseEntity<>(usedProps,HttpStatus.OK);
    }
    @RequestMapping(
            value = "/accept-decline/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsedProp> getRefuseAccept(@PathVariable Long id, @RequestParam("type") String type, Principal principal){

        User adminFan  = userService.findByUsername(principal.getName());
        UsedProp usedProp = null;
        try {
            usedProp = usedPropService.approveDecline(id, type, adminFan);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(usedProp, HttpStatus.OK);

    }
    @RequestMapping(
            value = "/{usedPropId}/accept-bid/{acceptedBidId}",
            method = RequestMethod.GET)
    public ResponseEntity<Bid> acceptBid(@PathVariable Long usedPropId, @PathVariable Long acceptedBidId){
       boolean success = usedPropService.acceptBid(usedPropId,acceptedBidId);
       if(success){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);

    }
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPropUsed(Principal principal, @Valid @RequestBody UsedProp usedProp, Errors errors) {
        if(errors.hasErrors()){
            return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
        }
        usedProp = usedPropService.createUsedProp(principal.getName(),usedProp);
        return new ResponseEntity<>(usedProp, HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsedProp> updatePropUsed(@RequestBody UsedProp usedProp) {
        UsedProp updatedUsedProp = usedPropService.save(usedProp);
        return new ResponseEntity<>(updatedUsedProp, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<UsedProp> deletePropUsed(@PathVariable("id") Long id) {
        usedPropService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
