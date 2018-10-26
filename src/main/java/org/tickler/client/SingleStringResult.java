package org.tickler.client;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jasper on 21/10/18.
 */
public class SingleStringResult extends CommandResult<String> {
    protected SingleStringResult(List<String> results) {
        super(results);
    }

    public SingleStringResult(String... results) {
        this(Arrays.asList(results));
    }
}
