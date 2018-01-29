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
public class PropNew extends Prop implements Serializable {

    @Column(nullable = false)
    private float price;

    @ManyToOne(optional = false)
    private AdminFan adminFan;

    @ManyToOne(optional = true)
    private RegisteredUser registeredUser;

    @ManyToOne(optional = false)
    private Show show;

    public PropNew() {
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public AdminFan getAdminFan() {
        return adminFan;
    }

    public void setAdminFan(AdminFan adminFan) {
        this.adminFan = adminFan;
    }

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}

