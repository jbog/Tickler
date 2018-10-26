package model.factories.rules;


import exceptions.InsufficientDataAvailableException;

import java.util.Map;

/**
 * Created by jasper on 14/10/18.
 */
public interface GeneratorRule {
    /**
     *
     * @param properties A key-value map of properties. It is the responsibility of the implementor to handle the reading and casting of the appropriate elements from this map.
     * @return {@code True} if the rule deems it possible to currently generate the {@link model.Tickle}, {@code False} otherwise.
     */
    public Boolean canGenerate(Map<String, ? extends Object> properties) throws InsufficientDataAvailableException;
}
