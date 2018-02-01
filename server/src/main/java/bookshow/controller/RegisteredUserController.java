package bookshow.controller;

import bookshow.model.users.RegisteredUser;
import bookshow.service.RegisteredUserService;
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
public class RegisteredUserController {

    @Autowired
    private RegisteredUserService RegisteredUserService;

    @RequestMapping(
            value = "/registeredUser",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RegisteredUser>> getRegisteredUsers() {
        List<RegisteredUser> registeredUsers = RegisteredUserService.findAll();
        return new ResponseEntity<>(registeredUsers, HttpStatus.OK);
    }
    @RequestMapping(
            value = "/registeredUser/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisteredUser> getRegisteredUser(@PathVariable("id") Long id) {
        RegisteredUser registeredUsers = RegisteredUserService.findOne(id);
        return new ResponseEntity<>(registeredUsers, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/registeredUser",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisteredUser> createRegisteredUser(@RequestBody RegisteredUser RegisteredUser) {
        RegisteredUser savedRegisteredUser = RegisteredUserService.save(RegisteredUser);
        return new ResponseEntity<>(savedRegisteredUser, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/registeredUser",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisteredUser> updateRegisteredUser(@RequestBody RegisteredUser RegisteredUser) {
        RegisteredUser updatedRegisteredUser = RegisteredUserService.save(RegisteredUser);
        return new ResponseEntity<>(updatedRegisteredUser, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/deleteRegisteredUser/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisteredUser> deleteRegisteredUser(@PathVariable("id") Long id) {
        RegisteredUserService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
