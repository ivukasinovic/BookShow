package bookshow.model.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by Ivan V. on 27-Jan-18
 */
@Entity
@DiscriminatorValue("ADMINFAN")
public class FanAdmin extends User implements Serializable {
    public FanAdmin() {
    }
}
