package org.tickler.client;

import java.util.Optional;

/**
 * Created by jasper on 21/10/18.
 */
public interface CallBack<T> {
    String foo = "f";
    public void callback(Optional<CommandResult<T>> result);
}
