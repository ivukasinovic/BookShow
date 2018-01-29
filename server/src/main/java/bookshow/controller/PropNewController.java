package bookshow.controller;

import bookshow.model.props.PropNew;
import bookshow.service.PropNewService;
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
public class PropNewController {
    @Autowired
    private  PropNewService propNewService;

    @RequestMapping(
            value = "/getPropNews",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PropNew>> getPropNews() {
        List<PropNew> PropNews = propNewService.findAll();
        return new ResponseEntity<>(PropNews, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/createPropNew",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PropNew> createPropNew(@RequestBody PropNew PropNew) {
        PropNew savedPropNew = propNewService.save(PropNew);
        return new ResponseEntity<>(savedPropNew, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/updatePropNew",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PropNew> updatePropNew(@RequestBody PropNew PropNew) {
        PropNew updatedPropNew = propNewService.save(PropNew);
        return new ResponseEntity<>(updatedPropNew, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/deletePropNew/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PropNew> deletePropNew(@PathVariable("id") Long id) {
        propNewService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
