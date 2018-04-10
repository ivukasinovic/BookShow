package bookshow.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.Show;
import bookshow.domain.ShowType;
import bookshow.service.ShowService;

@RestController
public class ShowController {

	@Autowired
	ShowService showService;

	@RequestMapping(value = "/all-shows", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Show>> getShowTheatre(@RequestParam(value = "type") String pathvar) {
		ArrayList<Show> retval = new ArrayList<Show>();
		List<Show> shows = showService.findAll();
		ShowType type;
		if (pathvar.equals("theatre"))
			type = ShowType.THEATRE;
		else if(pathvar.equals("cinema"))
				type = ShowType.CINEMA;
			else
				return null;	
		
		for (Show show : shows) {
			if (show.getType().equals(type)) {
				retval.add(show);
			}
		}
		
		return new ResponseEntity<>(retval, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/getShowById/{id}",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Show> getShow(@PathVariable String id){
		Long longId = new Long(Integer.parseInt(id));
		return new ResponseEntity<>(showService.findOne(longId), HttpStatus.OK);
	}
}
