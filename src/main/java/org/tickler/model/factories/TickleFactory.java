package org.tickler.model.factories;

import org.tickler.exceptions.ProductionException;
import org.tickler.model.Tickle;
import org.tickler.model.context.Comment;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by jasper on 12/10/18.
 */
@Entity
public abstract class TickleFactory {
    private Long identifier;
    /**
     * The comments associated with the tickles associated with the factory. These must be added automatically upon producing the Tickle.
     */
    private Collection<? extends Comment> comments;

    public TickleFactory() {
        this.setComments(new ArrayList<Comment>());
    }

    public Collection<? extends Comment> getComments() {
        return comments;
    }

    protected void setComments(Collection<? extends Comment> comments) {
        this.comments = comments;
    }

    public Long getIdentifier() {
        return identifier;
    }

    protected void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    /**
     * Produces the Tickle instance according to the state of the factory.
     * @return A Tickle instance.
     * @throws ProductionException Whenever generating the Tickle instance fails
     */
    public abstract Tickle produce() throws ProductionException;
}
