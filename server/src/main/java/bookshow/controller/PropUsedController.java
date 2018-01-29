package bookshow.controller;

import bookshow.model.props.PropUsed;
import bookshow.service.PropUsedService;
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
public class PropUsedController {
    @Autowired
    private PropUsedService propUsedService;

    @RequestMapping(
            value = "/getPropUseds",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PropUsed>> getPropUseds() {
        List<PropUsed> propUseds = propUsedService.findAll();
        return new ResponseEntity<>(propUseds, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/createPropUsed",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PropUsed> createPropUsed(@RequestBody PropUsed propUsed) {
        PropUsed savedPropUsed = propUsedService.save(propUsed);
        return new ResponseEntity<>(savedPropUsed, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/updatePropUsed",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PropUsed> updatePropUsed(@RequestBody PropUsed propUsed) {
        PropUsed updatedPropUsed = propUsedService.save(propUsed);
        return new ResponseEntity<>(updatedPropUsed, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/deletePropUsed/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PropUsed> deletePropUsed(@PathVariable("id") Long id) {
        propUsedService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
