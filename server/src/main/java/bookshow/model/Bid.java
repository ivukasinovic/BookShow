package bookshow.model;

import bookshow.model.props.PropUsed;
import bookshow.model.users.RegisteredUser;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ivan V. on 27-Jan-18
 */
@Entity
public class Bid implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false, unique = true)
    private String price;

    @Column(nullable = false)
    private boolean accepted;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RegisteredUser user;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PropUsed prop;

    public Bid() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }

    public PropUsed getProp() {
        return prop;
    }

    public void setProp(PropUsed prop) {
        this.prop = prop;
    }
}
