package model.factories;

import exceptions.ProductionException;
import model.Tickle;

import java.util.Date;

/**
 * Created by jasper on 14/10/18.
 */

public class SingleTickleFactory extends TickleFactory {
    private String tickleName;
    private Date tickleStartDate;
    private Date tickleEndDate;

    public SingleTickleFactory(String name, Date startDate, Date endDate) {
        this.setTickleName(name);
        this.setTickleStartDate(startDate);
        this.setTickleEndDate(endDate);
    }

    public String getTickleName() {
        return tickleName;
    }

    public Date getTickleStartDate() {
        return tickleStartDate;
    }

    public Date getTickleEndDate() {
        return tickleEndDate;
    }

    protected SingleTickleFactory setTickleName(String tickleName) {
        this.tickleName = tickleName;
        return this;
    }

    protected SingleTickleFactory setTickleStartDate(Date tickleStartDate) {
        this.tickleStartDate = tickleStartDate;
        return this;
    }

    protected SingleTickleFactory setTickleEndDate(Date tickleEndDate) {
        this.tickleEndDate = tickleEndDate;
        return this;
    }

    public Tickle produce() throws ProductionException {
        Tickle result = new Tickle();
        // TODO Implement - method visibility?
        return result;
    }
}
