package bookshow.model.props;

import bookshow.model.users.AdminFan;
import bookshow.model.users.RegisteredUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Ivan V. on 28-Jan-18
 */
@Entity
public class PropNew extends Prop implements Serializable {

    @Column(nullable = false)
    private float price;

    @ManyToOne(optional = false)
    private AdminFan adminFan;

    @ManyToOne(optional = true)
    private RegisteredUser registeredUser;

    public PropNew() {
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}

