package bookshow.model.props;

import bookshow.model.users.AdminFan;
import bookshow.model.users.RegisteredUser;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ivan V. on 27-Jan-18
 */
@Entity
@DiscriminatorValue("USED")
public class PropUsed extends Prop implements Serializable {

    @Column(name = "active_until", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date activeUntil;

    @Column(nullable = false)
    private UsedPropStatus status;

    //privremeno(Trebalo bi @OneToOne?)
    @Column(name = "accepted_bid",nullable = false)
    private boolean acceptedBid;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private AdminFan adminFan;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RegisteredUser registeredUser;

    public PropUsed() {
    }

    public Date getActiveUntil() {
        return activeUntil;
    }

    public void setActiveUntil(Date activeUntil) {
        this.activeUntil = activeUntil;
    }

    public UsedPropStatus getStatus() {
        return status;
    }

    public void setStatus(UsedPropStatus status) {
        this.status = status;
    }

    public boolean isAcceptedBid() {
        return acceptedBid;
    }

    public void setAcceptedBid(boolean acceptedBid) {
        this.acceptedBid = acceptedBid;
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
}
