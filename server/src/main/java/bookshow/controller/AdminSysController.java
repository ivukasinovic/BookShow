package bookshow.controller;

import bookshow.model.users.AdminFan;
import bookshow.model.users.AdminSys;
import bookshow.service.AdminSysService;
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
public class AdminSysController {
    @Autowired
    private AdminSysService adminSysService;

    @RequestMapping(
            value = "/getAdminSyss",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdminSys>> getAdminSyss() {
        List<AdminSys> adminSyss = adminSysService.findAll();
        return new ResponseEntity<>(adminSyss, HttpStatus.OK);
    }
    @RequestMapping(
            value = "/getAdminSys/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminSys> getAdminFans(@PathVariable("id") Long id) {
        AdminSys adminSys = adminSysService.findOne(id);
        return new ResponseEntity<>(adminSys, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/createAdminSys",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminSys> createAdminSys(@RequestBody AdminSys adminSys) {
        AdminSys savedAdminSys = adminSysService.save(adminSys);
        return new ResponseEntity<>(savedAdminSys, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/updateAdminSys",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminSys> updateAdminSys(@RequestBody AdminSys adminSys) {
        AdminSys updatedAdminSys = adminSysService.save(adminSys);
        return new ResponseEntity<>(updatedAdminSys, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/deleteAdminSys/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminSys> deleteRegisteredUser(@PathVariable("id") Long id) {
        adminSysService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
