package bookshow.service;

import java.util.List;

import bookshow.domain.movie.Auditorium;

public interface AuditoriumService {
	List<Auditorium> findAll();

	Auditorium findOne(Integer id);

	Auditorium save(Auditorium auditorium);

    void delete(Integer id);
}
