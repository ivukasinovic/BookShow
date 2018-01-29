package bookshow.controller;

import bookshow.model.users.AdminFan;
import bookshow.service.AdminFanService;
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
public class AdminFanController {

    @Autowired
    private AdminFanService adminFanService;

    @RequestMapping(
            value = "/getAdminFans",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdminFan>> getAdminFans() {
        List<AdminFan> adminFans = adminFanService.findAll();
        return new ResponseEntity<>(adminFans, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/createAdminFan",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminFan> createAdminFan(@RequestBody AdminFan adminFan) {
        AdminFan savedAdminFan = adminFanService.save(adminFan);
        return new ResponseEntity<>(savedAdminFan, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/updateAdminFan",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminFan> updateAdminFan(@RequestBody AdminFan adminFan) {
        AdminFan updatedAdminFan = adminFanService.save(adminFan);
        return new ResponseEntity<>(updatedAdminFan, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/deleteAdminFan/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminFan> deleteRegisteredUser(@PathVariable("id") Long id) {
        adminFanService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
