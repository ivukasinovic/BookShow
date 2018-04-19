package bookshow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshow.domain.users.Visit;
import bookshow.repository.VisitRepository;
import bookshow.service.VisitService;

@Service
public class VisitImpl implements VisitService{
	@Autowired
	private VisitRepository VisitRepository;

	@Override
	public Visit findById(Long Id) {
		return VisitRepository.findById(Id);
	}

	@Override
	public List<Visit> findByUserUsername(String username) {
		return VisitRepository.findByUserUsername(username);
	}

	@Override
	public List<Visit> findByShowName(String showName) {
		return VisitRepository.findByShowName(showName);
	}

	@Override
	public Visit save(Visit visit) {
		return VisitRepository.save(visit);
	}

	@Override
	public List<Visit> fintAll() {
		return VisitRepository.findAll();
	}

	@Override
	public void delete(Visit visit) {
		VisitRepository.delete(visit);
		
	}
	
	

}
