package bookshow.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
	
    @ManyToOne(optional = false)
    private Show show;
	
	@Column
	private String genre;
	
	@Column
	private String director;
	
	@Column
	private String duration;
	
	@Column
	private String imageAddress;
	
	@Column
	private double averageScore;
	
	@Column
	private String description;
	
	@Column
	private double price;
	
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getImageAddress() {
		return imageAddress;
	}

	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	@Override
	public String toString() {
		return "PlayFilm [id=" + id + ", name=" + name + ", actors=" + actors + ", show=" + show + ", genre=" + genre
				+ ", director=" + director + ", duration=" + duration + ", imageAddress=" + imageAddress
				+ ", averageScore=" + averageScore + ", description=" + description + ", price=" + price + "]";
	}
}
