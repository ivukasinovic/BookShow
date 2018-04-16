package bookshow.service;

import java.util.List;

import bookshow.domain.movie.Ticket;

public interface TicketService {
	List<Ticket> findAll();

	Ticket findOne(Long id);

	Ticket save(Ticket ticket);

    void delete(Long id);
    
    List<Ticket> findByDiscountGreaterThan(double value);
    List<Ticket> findBySeatAuditoriumShowIdAndDiscountGreaterThan(Long id, double value);
}
