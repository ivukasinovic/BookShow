package bookshow.domain.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Visit {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;
	
	@Column(nullable = false, unique = false)
    private String username;
	
	@Column(nullable = false, unique = false)
    private String showId;
	
	@Column(nullable = false, unique = false)
    private String showType;
	
	@Column(nullable = false, unique = false)
    private String showName;
	
	@Column(nullable = false, unique = false)
    private String date;

	public Visit(){}
	

	public Visit(String username, String showId, String showType, String showName, String date) {
		this.username = username;
		this.showId = showId;
		this.showType = showType;
		this.showName = showName;
		this.date = date;
	}



	public String getShowId() {
		return showId;
	}


	public void setShowId(String showId) {
		this.showId = showId;
	}


	public String getShowType() {
		return showType;
	}


	public void setShowType(String showType) {
		this.showType = showType;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

}
