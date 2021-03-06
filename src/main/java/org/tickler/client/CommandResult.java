package org.tickler.client;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by jasper on 21/10/18.
 */
public abstract class CommandResult<T> {
    private List<T> results;

    protected CommandResult(List<T> results) {
        this.setResults(results);
    }

    public T get(Integer index) {
        return this.results.get(index);
    }

    protected List<T> getResults() {
        return this.results;
    }

    public Stream<T> stream() {
        return this.getResults().stream();
    }

    public CommandResult<T> setResults(List<T> results) {
        this.results = results;
        return this;
    }
}
