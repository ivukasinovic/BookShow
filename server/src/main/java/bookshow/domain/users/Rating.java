package bookshow.domain.users;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ivan V. on 17-Apr-18
 */
@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    private Date date;

    private Long bronze;

    private Long silver;

    private Long gold;

    public Rating() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getBronze() {
        return bronze;
    }

    public void setBronze(Long bronze) {
        this.bronze = bronze;
    }

    public Long getSilver() {
        return silver;
    }

    public void setSilver(Long silver) {
        this.silver = silver;
    }

    public Long getGold() {
        return gold;
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }
}
