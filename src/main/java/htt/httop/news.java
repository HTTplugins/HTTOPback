package htt.httop;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "news")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class news {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;
    @Column(name = "publish_date")
    private Date publishDate;

    public int getId() {
        return id;
    }

    public void setId(int new_id) {
        this.id = new_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublish_date() {
        return publishDate;
    }

    public void setPublish_date(Date publish_date) {
        this.publishDate = publish_date;
    }
}
