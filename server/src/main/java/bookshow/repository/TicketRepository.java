package bookshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshow.domain.movie.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{
	List<Ticket> findByDiscountGreaterThan(double value);

	List<Ticket> findBySeatAuditoriumShowIdAndDiscountGreaterThan(Long id, double value);
}
