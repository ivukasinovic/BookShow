package bookshow.service;

import java.util.List;

import bookshow.domain.movie.Projection;

public interface ProjectionService {
	List<Projection> findAll();

	Projection findOne(Long id);

	Projection save(Projection projection);

    void delete(Long id);
}
