package bookshow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshow.domain.movie.Auditorium;
import bookshow.repository.AuditoriumRepository;
import bookshow.service.AuditoriumService;

@Service
public class AuditoriumServiceImpl implements AuditoriumService{

	@Autowired
	private AuditoriumRepository auditoriumRepository;
	
	@Override
	public List<Auditorium> findAll() {
		// TODO Auto-generated method stub
		return auditoriumRepository.findAll();
	}

	@Override
	public Auditorium findOne(Integer id) {
		// TODO Auto-generated method stub
		return auditoriumRepository.findOne(id);
	}

	@Override
	public Auditorium save(Auditorium auditorium) {
		// TODO Auto-generated method stub
		return auditoriumRepository.save(auditorium);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		auditoriumRepository.delete(id);
		
	}

}
