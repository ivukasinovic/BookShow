package bookshow.controller;

import bookshow.model.Show;
import bookshow.model.props.NewProp;
import bookshow.model.users.AdminFan;
import bookshow.service.AdminFanService;
import bookshow.service.NewPropService;
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
    private AdminFanService adminFanService;

    @RequestMapping(
            value = "/getNewProps",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NewProp>> getPropNews() {
        List<NewProp> newProps = newPropService.findAll();
        return new ResponseEntity<>(newProps, HttpStatus.OK);
    }
    //id filma/predstave
    @RequestMapping(
            value = "/createNewProp/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NewProp> createPropNew(@RequestBody NewProp newProp,@PathVariable("id") Long id) {
        Show show =showService.findOne(id);
        AdminFan adminFan = adminFanService.findOne(1L);
        newProp.setShow(show);
        newProp.setAdminFan(adminFan);
        NewProp savedNewProp = newPropService.save(newProp);
        return new ResponseEntity<>(savedNewProp, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/updateNewProp",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NewProp> updatePropNew(@RequestBody NewProp newProp) {
        NewProp updatedNewProp = newPropService.save(newProp);
        return new ResponseEntity<>(updatedNewProp, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/deleteNewProp/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NewProp> deletePropNew(@PathVariable("id") Long id) {
        newPropService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
