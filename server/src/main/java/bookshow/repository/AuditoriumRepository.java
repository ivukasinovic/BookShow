package bookshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshow.domain.movie.Auditorium;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer>{

}
