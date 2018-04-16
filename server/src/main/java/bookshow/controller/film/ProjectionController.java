package bookshow.controller.film;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.movie.Projection;
import bookshow.domain.movie.Repertoire;
import bookshow.service.ProjectionService;

@RestController
@RequestMapping(value="/projection")
public class ProjectionController {
	
	@Autowired
	ProjectionService projectionService;

	@RequestMapping(
			value = "/save", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Projection> saveProjection(@RequestBody Projection projection){
		return new ResponseEntity<>(projectionService.save(projection), HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/get-by-repertoire", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Projection>> getProjectionsByRepertoire(@RequestBody Repertoire repertoire){
		return new ResponseEntity<>(projectionService.findByRepertoire(repertoire), HttpStatus.OK);
	}
}
