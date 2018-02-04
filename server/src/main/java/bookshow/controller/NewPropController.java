package bookshow.controller;

import bookshow.model.Show;
import bookshow.model.props.NewProp;
import bookshow.model.users.FanAdmin;
import bookshow.service.FanAdminService;
import bookshow.service.NewPropService;
import bookshow.service.RegisteredUserService;
import bookshow.service.ShowService;
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
public class NewPropController {
    @Autowired
    private NewPropService newPropService;
    @Autowired
    private ShowService showService;
    @Autowired
    private FanAdminService fanAdminService;
    @Autowired
    private RegisteredUserService registeredUserService;

    @RequestMapping(
            value = "/newPropsAll",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NewProp>> getNewPropsAll() {
        List<NewProp> newProps = newPropService.findAll();
        return new ResponseEntity<>(newProps, HttpStatus.OK);
    }
    @RequestMapping(
            value = "/newProps",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NewProp>> getNewProps() {
        List<NewProp> newProps = newPropService.findByRegisteredUserIsNull();
        return new ResponseEntity<>(newProps, HttpStatus.OK);
    }
    
    //id filma/predstave
    @RequestMapping(
            value = "/newProps/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NewProp> createNewProp(@RequestBody NewProp newProp,@PathVariable("id") Long id) {
        //ceka se logovanje(hardkod)
        Show show =showService.findOne(id);
        FanAdmin fanAdmin = fanAdminService.findOne(1L);
        newProp.setShow(show);
        newProp.setFanAdmin(fanAdmin);
        NewProp savedNewProp = newPropService.save(newProp);
        return new ResponseEntity<>(savedNewProp, HttpStatus.CREATED);
    }
    @RequestMapping(
            value = "/newProps/reservation/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<NewProp> reservationNewProp(@PathVariable("id") Long id){
        NewProp newProp = newPropService.findOne(id);
        newProp.setRegisteredUser(registeredUserService.findOne(5L));
        newPropService.save(newProp);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(
            value = "/newProps",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NewProp> updateNewProp(@RequestBody NewProp newProp) {
        NewProp old = newPropService.findOne(newProp.getId());
        old.setTitle(newProp.getTitle());
        old.setDescription(newProp.getDescription());
        old.setImage(newProp.getImage());
        old.setPrice(newProp.getPrice());
        NewProp updatedNewProp = newPropService.save(old);
        return new ResponseEntity<>(updatedNewProp, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/newProps/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NewProp> deleteNewProp(@PathVariable("id") Long id) {
        newPropService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
