package bookshow.service;

import java.util.List;

import bookshow.domain.users.Visit;

public interface VisitService{

	Visit findById(Long Id);
	List<Visit> findByUsername(String username);
	List<Visit> findByShowName(String showName);
	Visit save(Visit visit);
	List<Visit> fintAll();
	void delete(Visit visit);
}
