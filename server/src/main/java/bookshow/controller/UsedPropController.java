package bookshow.controller;

import bookshow.model.props.UsedProp;
import bookshow.model.props.UsedPropStatus;
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
public class UsedPropController {
    @Autowired
    private UsedPropService usedPropService;
    @Autowired
    private RegisteredUserService registeredUserService;

    @RequestMapping(
            value = "/usedPropsAll",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsedProp>> getUsedPropsAll() {
        List<UsedProp> usedProps = usedPropService.findAll();
        return new ResponseEntity<>(usedProps, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/usedPropsCheck",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsedProp>> getUsedPropsCheck() {
        List<UsedProp> usedProps = usedPropService.findByFanAdminIsNotNull();
        return new ResponseEntity<>(usedProps, HttpStatus.OK);
    }
    @RequestMapping(
            value = "/usedProps",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsedProp>> getUsedProps() {
        List<UsedProp> usedProps = usedPropService.findByActiveUntilGreaterThanAndStatusEquals(new java.util.Date(),UsedPropStatus.APPROVED);
        return new ResponseEntity<>(usedProps, HttpStatus.OK);
    }
    @RequestMapping(
            value = "/usedProps/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsedProp> getUsedProp(@PathVariable("id") Long id) {
        UsedProp usedProp = usedPropService.findOne(id);
        return new ResponseEntity<>(usedProp, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/usedProps",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsedProp> createPropUsed(@RequestBody UsedProp usedProp) {
        //ceka se logovanje(hardkod)
        usedProp.setStatus(UsedPropStatus.WAITING);
        usedProp.setRegisteredUser(registeredUserService.findOne(5L));
        usedProp.setDateCreated(new java.util.Date());
        UsedProp savedUsedProp = usedPropService.save(usedProp);
        return new ResponseEntity<>(savedUsedProp, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/usedProps",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsedProp> updatePropUsed(@RequestBody UsedProp usedProp) {
        UsedProp updatedUsedProp = usedPropService.save(usedProp);
        return new ResponseEntity<>(updatedUsedProp, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/usedProps/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsedProp> deletePropUsed(@PathVariable("id") Long id) {
        usedPropService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
