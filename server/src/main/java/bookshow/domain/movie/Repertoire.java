package bookshow.domain.movie;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import bookshow.domain.Show;

@Entity
public class Repertoire implements Serializable{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DateShow dateShow;
	
	public Repertoire(){
		
	}

	public DateShow getDateShow() {
		return dateShow;
	}

	public void setDateShow(DateShow dateShow) {
		this.dateShow = dateShow;
	}
	
	
	
}
