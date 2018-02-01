package bookshow.controller;

import bookshow.model.users.SysAdmin;
import bookshow.service.SysAdminService;
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
public class SysAdminController {
    @Autowired
    private SysAdminService sysAdminService;

    @RequestMapping(
            value = "/sysAdmin",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SysAdmin>> getAdminSyss() {
        List<SysAdmin> syssAdmins = sysAdminService.findAll();
        return new ResponseEntity<>(syssAdmins, HttpStatus.OK);
    }
    @RequestMapping(
            value = "/sysAdmin/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SysAdmin> getAdminFans(@PathVariable("id") Long id) {
        SysAdmin sysAdmin = sysAdminService.findOne(id);
        return new ResponseEntity<>(sysAdmin, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/sysAdmin",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SysAdmin> createAdminSys(@RequestBody SysAdmin sysAdmin) {
        SysAdmin savedSysAdmin = sysAdminService.save(sysAdmin);
        return new ResponseEntity<>(savedSysAdmin, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/sysAdmin",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SysAdmin> updateAdminSys(@RequestBody SysAdmin sysAdmin) {
        SysAdmin updatedSysAdmin = sysAdminService.save(sysAdmin);
        return new ResponseEntity<>(updatedSysAdmin, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/sysAdmin/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SysAdmin> deleteRegisteredUser(@PathVariable("id") Long id) {
        sysAdminService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
