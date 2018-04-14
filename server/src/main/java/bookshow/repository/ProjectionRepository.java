package bookshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshow.domain.movie.Projection;

public interface ProjectionRepository extends JpaRepository<Projection, Long>{

}
