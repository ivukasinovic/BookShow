package bookshow.controller;

import bookshow.domain.users.User;
import bookshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ivan V.
 */
@RestController
public class UserController {
    @Autowired
    private UserService UserService;

    @PreAuthorize("hasAuthority('ADMINSYS')")
    @RequestMapping(
            value = "/users",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAdminFans() {
        List<User> Users = UserService.findAll();
        return new ResponseEntity<>(Users, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/users/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getAdminFan(@PathVariable("id") Long id) {
        User User = UserService.findOne(id);
        return new ResponseEntity<>(User, HttpStatus.OK);
    }


    @RequestMapping(
            value = "/users",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createAdminFan(@RequestBody User User) {
        User savedUser = UserService.save(User);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/users",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateAdminFan(@RequestBody User User) {
        User updatedUser = UserService.save(User);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/user/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
        UserService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
