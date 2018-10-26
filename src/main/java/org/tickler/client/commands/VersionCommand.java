package client.commands;

import java.util.Optional;

/**
 * Created by jasper on 21/10/18.
 */
public class VersionCommand extends CommandLineCommand {
    @Override
    protected Boolean hasArg() {
        return false;
    }

    @Override
    protected CommandLineCommand run(Callback commandLineCallback, Optional<String> arguments) throws IllegalArgumentException {
        return null;
    }
}
