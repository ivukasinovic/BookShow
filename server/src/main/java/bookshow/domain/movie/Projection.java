package bookshow.domain.movie;
import javax.persistence.*;

@Entity
public class Projection {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false)
	private String time;
	
	@ManyToOne(optional = false)
	private Auditorium auditorium;
	
	@ManyToOne(optional = false)
	private PlayFilm playfilm;
	
	public Projection(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}

	public PlayFilm getPlayfilm() {
		return playfilm;
	}

	public void setPlayfilm(PlayFilm playfilm) {
		this.playfilm = playfilm;
	}
	
	
}
