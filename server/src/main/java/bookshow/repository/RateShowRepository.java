package bookshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshow.domain.rating.RateShow;
import bookshow.domain.rating.UserShow;

public interface RateShowRepository extends JpaRepository<RateShow, UserShow>{

}
