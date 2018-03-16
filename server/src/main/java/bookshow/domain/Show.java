package bookshow.domain;

import bookshow.domain.props.NewProp;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@Entity
@Table(name = "show_ct")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private ShowType type;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "show")
    private Set<NewProp> props;

    public Show() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShowType getType() {
        return type;
    }

    public void setType(ShowType type) {
        this.type = type;
    }

    public Set<NewProp> getProps() {
        return props;
    }

    public void setProps(Set<NewProp> props) {
        this.props = props;
    }
}
