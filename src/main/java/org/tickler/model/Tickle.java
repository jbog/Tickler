package model;

import model.actions.TriggerAction;
import model.context.Comment;
import model.factories.TickleFactory;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by jasper on 12/10/18.
 */
@Entity
public class Tickle {
    private Long identifier;
    private String name;
    private TickleFactory generator;
    private Date startDate;
    private Date endDate;
    private Collection<? super Comment> comments;
    private Collection<? super TriggerAction> listeners;

    public Tickle() {
        this.setComments(new ArrayList<Comment>(5));
        this.setListeners(new HashSet<TriggerAction>(2));
    }

    public Long getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public TickleFactory getGenerator() {
        return generator;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Collection<? super Comment> getComments() {
        return comments;
    }

    public Collection<? super TriggerAction> getListeners() {
        return listeners;
    }

    protected Tickle setIdentifier(Long identifier) {
        this.identifier = identifier;
        return this;
    }

     Tickle setName(String name) {
        this.name = name;
        return this;
    }

     Tickle setGenerator(TickleFactory generator) {
        this.generator = generator;
        return this;
    }

     Tickle setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

     Tickle setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    protected Tickle setComments(Collection<? super Comment> comments) {
        this.comments = comments;
        return this;
    }

    protected Tickle setListeners(Collection<? super TriggerAction> listeners) {
        this.listeners = listeners;
        return this;
    }

    public Tickle addComment(Comment newComment) {
        this.comments.add(newComment);
        return this;
    }

    public Tickle addListener(TriggerAction newListener) {
        this.listeners.add(newListener);
        return this;
    }
}
