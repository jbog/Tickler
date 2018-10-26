package model.factories;

import exceptions.InsufficientDataAvailableException;
import exceptions.ProductionException;
import model.Tickle;
import model.factories.rules.GeneratorRule;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jasper on 14/10/18.
 */
public class PeriodicTickleFactory extends TickleFactory {
    /**
     * The last date a {@link Tickle} was generated from this factory
     */
    private Date dateAdded;
    private GeneratorRule generatorRule;


    public Tickle produce() throws ProductionException {
        Tickle result = new Tickle();
        // TODO Implement
        return result;
    }

    public GeneratorRule getGeneratorRule() {
        return generatorRule;
    }

    protected PeriodicTickleFactory setGeneratorRule(GeneratorRule generatorRule) {
        this.generatorRule = generatorRule;
        return this;
    }

    public Boolean canGenerate() throws InsufficientDataAvailableException {
        Map<String, Object> generatorData = new HashMap<String, Object>(1);
        generatorData.put("DateAdded", this.getDateAdded());
        return this.getGeneratorRule().canGenerate(generatorData);
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    protected PeriodicTickleFactory setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
        return this;
    }
}
