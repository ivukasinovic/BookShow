package bookshow.domain.movie;

import javax.persistence.*;

import bookshow.domain.Show;

@Entity
public class Auditorium {

	@Id
    private int number;
	
	@ManyToOne(optional = false)
	private Show show;
	
	public Auditorium(){
		
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}
	
	
}
