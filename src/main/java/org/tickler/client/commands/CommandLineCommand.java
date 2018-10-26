package client.commands;

import java.util.Optional;

/**
 * Created by jasper on 21/10/18.
 */
public abstract class CommandLineCommand {
    private String description;

    public String getDescription() {
        return description;
    }

    protected CommandLineCommand setDescription(String description) {
        this.description = description;
        return this;
    }

    protected abstract Boolean hasArg();

    protected abstract CommandLineCommand run(Callback commandLineCallback, Optional<String> arguments) throws IllegalArgumentException;
}
