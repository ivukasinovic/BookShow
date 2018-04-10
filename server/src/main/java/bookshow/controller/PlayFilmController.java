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

import bookshow.domain.PlayFilm;
import bookshow.service.PlayFilmService;

@RestController
public class PlayFilmController {
	
	@Autowired
	PlayFilmService playFilmService;
	
	
	@RequestMapping(
			value = "/new-play-film", 
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlayFilm> createPlayFilm(@RequestBody PlayFilm playfilm){
		playfilm.setAverageScore(0);
		PlayFilm saved = playFilmService.save(playfilm);
		
		return new ResponseEntity<>(saved, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/get-show-repertoire/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PlayFilm>> getShowsRepertoire(@PathVariable String id){
		Long longId = new Long(Integer.parseInt(id));
		return new ResponseEntity<>(playFilmService.findByShowId(longId), HttpStatus.OK);
	}

}
