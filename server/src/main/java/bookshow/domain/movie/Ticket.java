package bookshow.domain.movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 
	 @ManyToOne
	 private PlayFilm playfilm;
	 
	 public Ticket(){
		 
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PlayFilm getPlayfilm() {
		return playfilm;
	}

	public void setPlayfilm(PlayFilm playfilm) {
		this.playfilm = playfilm;
	}
	 
	 

	 
}
