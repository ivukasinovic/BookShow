package bookshow.service;

import java.util.List;

import bookshow.domain.PlayFilm;

public interface PlayFilmService {
	List<PlayFilm> findAll();

    PlayFilm findOne(Long id);

    PlayFilm save(PlayFilm playfilm);

    void delete(Long id);
    
    List<PlayFilm> findByShowId(Long id);
}
