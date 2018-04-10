package bookshow.controller;

import bookshow.domain.Show;
import bookshow.domain.props.NewProp;
import bookshow.domain.users.User;
import bookshow.security.TokenUtils;
import bookshow.service.NewPropService;
import bookshow.service.ShowService;
import bookshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@RequestMapping(value="/new-props")
@RestController
public class NewPropController {
    @Autowired
    private NewPropService newPropService;
    @Autowired
    private ShowService showService;
    @Autowired
    private UserService userService;
    @Autowired
    private TokenUtils tokenUtils;


    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NewProp>> getNewPropsAll() {
        List<NewProp> newProps = newPropService.findAll();
        return new ResponseEntity<>(newProps, HttpStatus.OK);
    }

    //vraca one koji nisu rezervisani
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NewProp>> getNewProps() {
        List<NewProp> newProps = newPropService.findByUserIsNull();
        return new ResponseEntity<>(newProps, HttpStatus.OK);
    }
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NewProp> getNewProp(@PathVariable Long id){
        NewProp newProp = newPropService.findOne(id);
        return new ResponseEntity<>(newProp, HttpStatus.OK);
    }

    //id filma/predstave
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NewProp> createNewProp(Principal principal, @RequestBody NewProp newProp, @PathVariable("id") Long id) {
        Show show = showService.findOne(id);
        User User = userService.findByUsername(principal.getName());
        newProp.setShow(show);
        newProp.setFanAdmin(User);
        NewProp savedNewProp = newPropService.save(newProp);
        return new ResponseEntity<>(savedNewProp, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/reserve/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<NewProp> reservationNewProp(@PathVariable("id") Long id,Principal principal) {
        NewProp newProp = newPropService.findOne(id);
        String username = principal.getName();
        newProp.setUser(userService.findByUsername(username));
        newPropService.save(newProp);
        return new ResponseEntity<>(newProp,HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NewProp> updateNewProp(@RequestBody NewProp newProp, @PathVariable Long id) {
        Show show = showService.findOne(id);
        NewProp old = newPropService.findOne(newProp.getId());
        old.setShow(show);
        old.setTitle(newProp.getTitle());
        old.setDescription(newProp.getDescription());
        old.setImage(newProp.getImage());
        old.setPrice(newProp.getPrice());
        NewProp updatedNewProp = newPropService.save(old);
        return new ResponseEntity<>(updatedNewProp, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<NewProp> deleteNewProp(@PathVariable("id") Long id) {
        newPropService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
