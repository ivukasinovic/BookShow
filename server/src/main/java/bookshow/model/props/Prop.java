package bookshow.model.props;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

/**
 * Created by Ivan V. on 27-Jan-18
 */
@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
public abstract class Prop {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(nullable = true)
    private String image;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;


    public Prop() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return dateCreated;
    }

    public void setCreatedDate(Date createdDate) {
        this.dateCreated = createdDate;
    }

    public String getUrl() {
        return image;
    }

    public void setUrl(String url) {
        this.image = url;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
