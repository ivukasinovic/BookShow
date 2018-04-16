package bookshow.domain.movie;


import javax.persistence.*;

import bookshow.domain.Show;


@Entity
@Table(name = "playfilm_ct")
public class PlayFilm {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private String actors;
	
	@Column
	private String genre;
	
	@Column
	private String director;
	
	@Column
	private String duration;
	
	@Column
	private String imageUrl;
	
	@Column
	private double averageScore;
	
	@Column
	private String description;
	
	@ManyToOne(optional = false)
	private Show show;
	
	public PlayFilm(){
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public Show getShow() {
		return show;
	}


	public void setShow(Show show) {
		this.show = show;
	}

	
	
	
}
