package bookshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.Show;
import bookshow.domain.DTOs.DoubleDTO;
import bookshow.domain.rating.RateShow;
import bookshow.domain.users.User;
import bookshow.service.RateShowService;
import bookshow.service.ShowService;
import bookshow.service.UserService;

@RestController
@RequestMapping(value = "/rateshow")
public class RateShowController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private RateShowService rateShowService;
	
	@RequestMapping(
            value = "/save/{username}/{showId}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RateShow> createAdminFan(@RequestBody RateShow rateShow, @PathVariable String username, @PathVariable String showId) {
		Long showIdLong = new Long(Integer.parseInt(showId));
		User user = userService.findByUsername(username);
		Show show = showService.findOne(showIdLong);
		rateShow.getUserShow().setShow(show);
		rateShow.getUserShow().setUser(user);
        return new ResponseEntity<>(rateShowService.save(rateShow), HttpStatus.OK);
    }
	
	@RequestMapping(
            value = "/calculate-show-rating/{showId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoubleDTO> createAdminFan(@PathVariable String showId) {
		Long showIdLong = new Long(Integer.parseInt(showId));
		List<RateShow> showsRatings = rateShowService.findByUserShowShowId(showIdLong);
		double sum = 0;
		for(int i = 0; i < showsRatings.size(); i++){
			sum += showsRatings.get(i).getRating();
		}
		
        return new ResponseEntity<>(new DoubleDTO(sum / (double)showsRatings.size()), HttpStatus.OK);
    }

}
