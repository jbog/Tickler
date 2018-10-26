package org.tickler.model.actions;

import org.tickler.model.Tickle;

/**
 * Created by jasper on 12/10/18.
 */
public interface TriggerAction {
    /**
     * Run the action associated with the tickle
     * @param tickle the tickle for which the action must be performed.
     */
    public void run(Tickle tickle);
}
