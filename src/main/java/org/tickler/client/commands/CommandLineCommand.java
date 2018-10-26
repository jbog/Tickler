package org.tickler.client.commands;

import org.tickler.client.CallBack;
import org.tickler.client.CommandResult;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by jasper on 21/10/18.
 */
public abstract class CommandLineCommand<T> {
    public CommandLineCommand() {
    }

    public CommandLineCommand<T> run(CallBack<T> commandLineCallback, Optional<List<String>> arguments) throws IllegalArgumentException {
        Optional<CommandResult<T>> result = this.processArguments(arguments);
        commandLineCallback.callback(result);
        return this;
    }

    protected abstract Optional<CommandResult<T>> processArguments(Optional<List<String>> arguments);
}
