package bookshow.model.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by Ivan V. on 27-Jan-18
 */
@Entity
@DiscriminatorValue("REGISTERED")
public class RegisteredUser extends User implements Serializable {

}
