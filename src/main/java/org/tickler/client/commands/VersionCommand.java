package org.tickler.client.commands;

import org.tickler.client.CommandResult;
import org.tickler.client.SingleStringResult;
import java.util.List;
import java.util.Optional;

/**
 * Created by jasper on 21/10/18.
 */
public class VersionCommand extends CommandLineCommand<String> {

    public VersionCommand() {
        super();
    }

    @Override
    protected Optional<CommandResult<String>> processArguments(Optional<List<String>> arguments) {
        return Optional.of(new SingleStringResult(this.getClass().getPackage().getImplementationVersion()));
    }
}
