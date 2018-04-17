package bookshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshow.domain.users.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long>{
	Visit findById(Long Id);
	List<Visit> findByUsername(String username);
	List<Visit> findByShowName(String showName);
	
}
