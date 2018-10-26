package org.tickler.client.commands;

import org.apache.commons.cli.HelpFormatter;
import org.tickler.CommandLine;
import org.tickler.client.CallBack;
import org.tickler.client.CommandResult;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;

/**
 * Created by jasper on 21/10/18.
 */
public class HelpCommand extends CommandLineCommand<String> {

    private static final String HELP_MESSAGE = "Help me!"; // TODO

    public HelpCommand() {
        super();
    }

    @Override
    public HelpCommand run(CallBack<String> commandLineCallback, Optional<List<String>> arguments) throws IllegalArgumentException {
        PrintWriter stringWriter = new PrintWriter(new StringWriter());
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(stringWriter, 80, "tickler", "Easy to use digital tickle file with synchronization support", ((CommandLine) commandLineCallback).getCommandLineOptions(), 0, 0,"");
        Optional<CommandResult<String>> result = this.processArguments(arguments);
        commandLineCallback.callback(result);
        return this;
    }

    @Override
    protected Optional<CommandResult<String>> processArguments(Optional<List<String>> arguments) {
        return Optional.empty();
    }
}
