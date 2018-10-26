package model.context;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by jasper on 12/10/18.
 */
@Entity
public class Comment {
    private Long identifier;
    private Date addedDate;
    private String contents;

    public Comment() {

    }

    public Comment(Date addedDate, String contents) {
        this.setAddedDate(addedDate);
        this.setContents(contents);
    }

    public Long getIdentifier() {
        return identifier;
    }

    protected void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    protected void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getContents() {
        return contents;
    }

    protected Comment setContents(String contents) {
        this.contents = contents;
        return this;
    }
}
