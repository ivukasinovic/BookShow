package bookshow.domain.rating;

import java.io.Serializable;

import javax.persistence.*;


@Entity
public class RateShow implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@EmbeddedId
	private UserShow userShow;
	
	@Column
	private double rating;
	
	public RateShow(){
		
	}

	public UserShow getUserShow() {
		return userShow;
	}

	public void setUserShow(UserShow userShow) {
		this.userShow = userShow;
	}
	
	
	
	
}
