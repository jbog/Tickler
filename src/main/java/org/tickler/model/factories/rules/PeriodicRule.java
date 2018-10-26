package org.tickler.model.factories.rules;

import org.tickler.exceptions.InsufficientDataAvailableException;
import org.apache.commons.lang3.time.DateUtils;

import javax.persistence.Entity;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by jasper on 14/10/18.
 */
@Entity
public class PeriodicRule implements GeneratorRule {
    private Boolean inWorkDay;
    private Integer intervalLength;

    public PeriodicRule() {

    }

    public Boolean getInWorkDay() {
        return inWorkDay;
    }

    protected PeriodicRule setInWorkDay(Boolean inWorkDay) {
        this.inWorkDay = inWorkDay;
        return this;
    }

    public Integer getIntervalLength() {
        return intervalLength;
    }

    protected PeriodicRule setIntervalLength(Integer intervalLength) {
        this.intervalLength = intervalLength;
        return this;
    }

    public Boolean canGenerate(Map<String, ? extends Object> properties) throws InsufficientDataAvailableException {
        if (!properties.containsKey("DateAdded")) {
            throw new InsufficientDataAvailableException("No DateAdded available");
        }
        if (!(properties.get("DateAdded") instanceof Date)) {
            throw new InsufficientDataAvailableException("DateAdded not of type java.util.Date");
        }
        Date dateAdded = (Date) properties.get("DateAdded");
        Date earliestApplicableDate = DateUtils.addDays(dateAdded, this.getIntervalLength());
        if (this.getInWorkDay()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            calendar.setTime(earliestApplicableDate);
            while (calendar.get(Calendar.DAY_OF_WEEK) == 1 || calendar.get(Calendar.DAY_OF_WEEK) == 7) {
                calendar.add(Calendar.DATE, 1);
            }
            earliestApplicableDate = calendar.getTime();
        }
        Date now = Calendar.getInstance().getTime();
        return now.after(earliestApplicableDate);
    }
}
