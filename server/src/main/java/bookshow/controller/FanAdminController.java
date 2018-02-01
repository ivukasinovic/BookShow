package bookshow.controller;

import bookshow.model.users.FanAdmin;
import bookshow.service.FanAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ivan V. on 28-Jan-18
 */
@RestController
public class FanAdminController {

    @Autowired
    private FanAdminService fanAdminService;

    @RequestMapping(
            value = "/fanAdmins",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FanAdmin>> getAdminFans() {
        List<FanAdmin> fanAdmins = fanAdminService.findAll();
        return new ResponseEntity<>(fanAdmins, HttpStatus.OK);
    }
    @RequestMapping(
            value = "/fanAdmins/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FanAdmin> getAdminFan(@PathVariable("id") Long id) {
        FanAdmin fanAdmin = fanAdminService.findOne(id);
        return new ResponseEntity<>(fanAdmin, HttpStatus.OK);
    }


    @RequestMapping(
            value = "/fanAdmins",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FanAdmin> createAdminFan(@RequestBody FanAdmin fanAdmin) {
        FanAdmin savedFanAdmin = fanAdminService.save(fanAdmin);
        return new ResponseEntity<>(savedFanAdmin, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/fanAdmins",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FanAdmin> updateAdminFan(@RequestBody FanAdmin fanAdmin) {
        FanAdmin updatedFanAdmin = fanAdminService.save(fanAdmin);
        return new ResponseEntity<>(updatedFanAdmin, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/fanAdmin/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FanAdmin> deleteRegisteredUser(@PathVariable("id") Long id) {
        fanAdminService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
