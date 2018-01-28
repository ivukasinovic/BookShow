package bookshow.model.props;

import bookshow.model.Show;
import bookshow.model.users.AdminFan;
import bookshow.model.users.RegisteredUser;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ivan V. on 28-Jan-18
 */
@Entity
@DiscriminatorValue("NEW")
public class PropNew extends Prop implements Serializable {

    @Column(nullable = false)
    private float price;

    @ManyToOne(optional = false)
    private Show show;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RegisteredUser user;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private AdminFan admin;

    public PropNew() {
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }

    public AdminFan getAdmin() {
        return admin;
    }

    public void setAdmin(AdminFan admin) {
        this.admin = admin;
    }
}

