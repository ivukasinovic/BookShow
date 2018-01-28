package bookshow.model;

import bookshow.model.props.PropNew;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Ivan V. on 28-Jan-18
 */
@Entity
public class Show implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "show")
    private Set<PropNew> newProps;

    public Show(){

    }

}
