package org.tickler.client.commands;

import org.tickler.client.CommandResult;
import java.util.List;
import java.util.Optional;

/**
 * Created by jasper on 21/10/18.
 */
public class OrientationCommand extends CommandLineCommand<String> {

    public OrientationCommand() {
        super();
    }

    @Override
    protected Optional<CommandResult<String>> processArguments(Optional<List<String>> arguments) {
        arguments.orElseThrow(() -> new IllegalArgumentException("Unexpected input for " + this.getClass().getSimpleName() + ": expected argument"));
        arguments.ifPresent(
                a -> {
                    if (a.size() != 1) {
                        new IllegalArgumentException("Unexpected input for " + this.getClass().getSimpleName() + ": expected only one argument, found " + a.size());
                    }
                    String argument = a.get(0).toLowerCase().trim(); // TODO Server listener, client listener

                }
        );
        return Optional.empty();
    }
}
